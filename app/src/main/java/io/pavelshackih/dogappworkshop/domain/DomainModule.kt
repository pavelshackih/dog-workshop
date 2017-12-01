package io.pavelshackih.dogappworkshop.domain

import io.pavelshackih.dogappworkshop.domain.dogs.DogsInteractor
import org.koin.dsl.module.Module

class DomainModule : Module() {

    override fun context() = applicationContext {
        provide { DogsInteractor() }
    }
}
