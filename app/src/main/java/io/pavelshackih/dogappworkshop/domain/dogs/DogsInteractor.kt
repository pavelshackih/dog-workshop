package io.pavelshackih.dogappworkshop.domain.dogs

import io.pavelshackih.dogappworkshop.domain.Breed
import io.pavelshackih.dogappworkshop.domain.repository.LocalRepository
import io.pavelshackih.dogappworkshop.domain.repository.RemoteRepository
import io.pavelshackih.dogappworkshop.domain.wrapper.AndroidWrapper
import io.pavelshackih.dogappworkshop.util.inject
import io.reactivex.Single

class DogsInteractor {

    private val androidWrapper: AndroidWrapper by inject()
    private val localRepository: LocalRepository by inject()
    private val remoteRepository: RemoteRepository by inject()

    fun getDogs(): Single<List<Breed>> {
        return if (androidWrapper.isNetworkAvailable()) {
            remoteRepository.dogs
        } else {
            localRepository.dogs
        }
    }
}