package jo.kotlin.mvpsample.network.retrofit

import jo.kotlin.mvpsample.network.interceptor.ApplicationInterceptor
import jo.kotlin.mvpsample.network.interceptor.NetworkInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Jo on 2018. 4. 2.
 */

private fun createOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.addNetworkInterceptor(NetworkInterceptor())
    builder.addInterceptor(ApplicationInterceptor())
    return builder.build()
}

fun createRetrofit(): NetworkCallbackService {
    val builder = Retrofit.Builder()
    builder.baseUrl("https://api.flickr.com/services/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
    val retrofit = builder.build()
    return retrofit.create(NetworkCallbackService::class.java!!)
}