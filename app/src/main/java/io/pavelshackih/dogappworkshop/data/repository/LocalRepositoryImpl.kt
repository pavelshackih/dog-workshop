package io.pavelshackih.dogappworkshop.data.repository

import io.pavelshackih.dogappworkshop.data.local.DogsDao
import io.pavelshackih.dogappworkshop.domain.Breed
import io.pavelshackih.dogappworkshop.domain.repository.LocalRepository
import io.pavelshackih.dogappworkshop.util.inject
import io.reactivex.Single

class LocalRepositoryImpl : LocalRepository {

    private val dao: DogsDao by inject()

    override fun getDogs(): Single<List<Breed>> {
        return dao.findAll().map { list -> list.map { Breed(it.breed, it.image) } }
    }
}