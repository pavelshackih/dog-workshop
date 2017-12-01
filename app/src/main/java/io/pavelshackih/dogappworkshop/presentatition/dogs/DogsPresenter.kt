package io.pavelshackih.dogappworkshop.presentatition.dogs

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.pavelshackih.dogappworkshop.domain.dogs.DogsInteractor
import io.pavelshackih.dogappworkshop.util.RxScheduler
import io.pavelshackih.dogappworkshop.util.inject

@InjectViewState
class DogsPresenter : MvpPresenter<DogsView>() {

    private val rxScheduler: RxScheduler by inject()

    private val interactor: DogsInteractor by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProgress()

        interactor.getDogs()
                .subscribeOn(rxScheduler.getNetwork())
                .observeOn(rxScheduler.getMain())
                .subscribe({ p1 ->
                    viewState.hideProgress()
                    viewState.setDogs(p1)
                }, { error ->
                    Log.e("ERROR", "", error)
                })
    }
}