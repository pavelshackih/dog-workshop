package io.pavelshackih.dogappworkshop.presentatition.dogs

import io.pavelshackih.dogappworkshop.domain.dogs.DogsInteractor
import io.pavelshackih.dogappworkshop.util.RxScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class DogsPresenterTest {

    @Mock
    lateinit var dogsView: DogsView

    @Mock
    lateinit var dogsViewState: `DogsView$$State`

    @Mock
    lateinit var rxSchedulers: RxScheduler

    @Mock
    lateinit var dogsInteractor: DogsInteractor

    lateinit var presenter: DogsPresenter

    @Before
    fun setUp() {
        presenter = DogsPresenter()
    }

    @Test
    fun onFirstViewAttachTest() {
        presenter.setViewState(dogsViewState)
        presenter.attachView(dogsView)

        Mockito.verify(dogsInteractor).getDogs()
    }
}