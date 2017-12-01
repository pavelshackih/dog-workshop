package io.pavelshackih.dogappworkshop.util

import org.koin.dsl.context.Context
import org.koin.dsl.module.Module

class MainModule : Module() {
    override fun context(): Context = applicationContext {
        provide { RxSchedulerImpl() } bind RxScheduler::class
    }
}