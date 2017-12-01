package io.pavelshackih.dogappworkshop.presentatition.dogs

import com.arellomobile.mvp.MvpView
import io.pavelshackih.dogappworkshop.domain.Breed

interface DogsView : MvpView {

    fun setDogs(list: List<Breed>)

    fun showProgress()

    fun hideProgress()
}