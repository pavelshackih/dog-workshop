package io.pavelshackih.dogappworkshop.data.remote

import com.google.gson.annotations.SerializedName

data class BreedsResponse(@SerializedName("status") val status: String,
                          @SerializedName("message") val message: Map<String, List<String>>)

data class ImageResponse(@SerializedName("status") val status: String,
                         @SerializedName("message") val message: String)