package io.pavelshackih.dogappworkshop.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface RxScheduler {
    fun getNetwork(): Scheduler
    fun getComputation(): Scheduler
    fun getMain(): Scheduler
}

class RxSchedulerImpl : RxScheduler {
    override fun getNetwork(): Scheduler = Schedulers.io()
    override fun getComputation(): Scheduler = Schedulers.computation()
    override fun getMain(): Scheduler = AndroidSchedulers.mainThread()
}

class TestRxScheduler : RxScheduler {

    override fun getNetwork(): Scheduler = Schedulers.trampoline()

    override fun getComputation(): Scheduler = Schedulers.trampoline()

    override fun getMain(): Scheduler = Schedulers.trampoline()

}