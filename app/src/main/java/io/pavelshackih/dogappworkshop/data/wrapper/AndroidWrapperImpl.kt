package io.pavelshackih.dogappworkshop.data.wrapper

import io.pavelshackih.dogappworkshop.domain.wrapper.AndroidWrapper

class AndroidWrapperImpl : AndroidWrapper {

    override fun isNetworkAvailable(): Boolean {
        return true
    }
}