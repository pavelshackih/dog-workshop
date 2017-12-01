package io.pavelshackih.dogappworkshop.data.repository

import io.pavelshackih.dogappworkshop.data.remote.DogApi
import io.pavelshackih.dogappworkshop.data.remote.ImageResponse
import io.pavelshackih.dogappworkshop.domain.Breed
import io.pavelshackih.dogappworkshop.domain.repository.RemoteRepository
import io.pavelshackih.dogappworkshop.util.inject
import io.reactivex.Observable
import io.reactivex.Single

class RemoteRepositoryImpl : RemoteRepository {

    private val dogApi: DogApi by inject()

    override fun getDogs(): Single<List<Breed>> {
        return dogApi.getBreeds()
                .map { response -> response.message.keys }
                .flatMapObservable { Observable.fromIterable(it) }
                .flatMap({ p ->
                    dogApi.getRandomBreedImage(p).toObservable()
                }, { p1: String, p2: ImageResponse ->
                    Breed(p1, p2.message)
                }).toList()
    }
}
