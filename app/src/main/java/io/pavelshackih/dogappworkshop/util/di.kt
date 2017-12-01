package io.pavelshackih.dogappworkshop.util

import org.koin.standalone.StandAloneContext

inline fun <reified T> Any.inject(name: String = ""): Lazy<T> = lazy { StandAloneContext.koinContext.get<T>(name) }