package io.pavelshackih.dogappworkshop

import android.app.Application
import io.pavelshackih.dogappworkshop.data.DataModule
import io.pavelshackih.dogappworkshop.domain.DomainModule
import io.pavelshackih.dogappworkshop.util.MainModule
import org.koin.Koin
import org.koin.standalone.StandAloneContext

class DogApp : Application() {

    override fun onCreate() {
        super.onCreate()
        StandAloneContext.koinContext = Koin().build(
                MainModule(),
                DataModule(this),
                DomainModule()
        )
    }
}