package io.pavelshackih.dogappworkshop.domain.dogs

import io.pavelshackih.dogappworkshop.domain.repository.LocalRepository
import io.pavelshackih.dogappworkshop.domain.repository.RemoteRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DogsInteractorTest {

    @Mock
    lateinit var localRepository: LocalRepository

    @Mock
    lateinit var remoteRepository: RemoteRepository

    lateinit var interactor: DogsInteractor

    @Before
    fun setUp() {
        interactor = DogsInteractor()
    }

    @Test
    fun getDogs() {
        val dogs = interactor.getDogs()

        val listOfDogs = dogs.blockingGet()


    }
}