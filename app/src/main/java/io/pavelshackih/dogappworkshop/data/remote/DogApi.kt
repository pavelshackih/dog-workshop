package io.pavelshackih.dogappworkshop.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.pavelshackih.dogappworkshop.BuildConfig
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET("/api/breeds/list/all")
    fun getBreeds(): Single<BreedsResponse>

    @GET("/api/breed/{breedName}/images/random")
    fun getRandomBreedImage(@Path("breedName") breedName: String): Single<ImageResponse>

    companion object {

        private const val BASE_URL = "https://dog.ceo"

        val API: DogApi by lazy {
            val interceptor = HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
            val client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            retrofit.create(DogApi::class.java)
        }
    }
}