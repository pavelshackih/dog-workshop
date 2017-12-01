package io.pavelshackih.dogappworkshop.data

import android.arch.persistence.room.Room
import android.content.Context
import io.pavelshackih.dogappworkshop.data.local.DogsDb
import io.pavelshackih.dogappworkshop.data.remote.DogApi
import io.pavelshackih.dogappworkshop.data.repository.LocalRepositoryImpl
import io.pavelshackih.dogappworkshop.data.repository.RemoteRepositoryImpl
import io.pavelshackih.dogappworkshop.domain.repository.LocalRepository
import io.pavelshackih.dogappworkshop.domain.repository.RemoteRepository
import org.koin.dsl.module.Module

class DataModule(private val context: Context) : Module() {

    override fun context() = applicationContext {
        provide { createDb().dogsDao() }
        provide { DogApi.API }
        provide { RemoteRepositoryImpl() } bind RemoteRepository::class
        provide { LocalRepositoryImpl() } bind LocalRepository::class
    }

    private fun createDb(): DogsDb = Room.databaseBuilder(context, DogsDb::class.java, "db").build()
}