package jo.kotlin.mvpsample.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Jo on 2018. 3. 30.
 */


class NetworkInterceptor : Interceptor {

    private val TAG: String = NetworkInterceptor::class.java.simpleName

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
//        Log.d(TAG, "intercept : request method " + request.method())
//        Log.d(TAG, "intercept : request url " + request.headers())
//        Log.d(TAG, "intercept : request connection " + chain.connection()!!)
//
//        Log.d(TAG, "/////////////////////////////////////////////////////////////////")

        var response = chain.proceed(request)
//        Log.d(TAG, "intercept : response requested url " + response.request().url())
//        Log.d(TAG, "intercept : response header" + response.headers())
//        Log.d(TAG, "intercept : response code" + response.code())

//        when (response.code()) {
//            200 -> Log.d(TAG, "network error : 성공")
//            401 -> {
//                Log.d(TAG, "network error : 401 에러")
//                val newRequest1 = request.newBuilder()
//                        //                        .head()
//                        .build()
//                response = chain.proceed(newRequest1)
//            }
//            500 -> Log.d(TAG, "network error : 500 서버 에러")
//        }

        return response

    }

}