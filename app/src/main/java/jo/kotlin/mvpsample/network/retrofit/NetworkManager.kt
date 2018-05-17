package jo.kotlin.mvpsample.network.retrofit

import jo.kotlin.mvpsample.util.Mockable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Jo on 2018. 4. 2.
 */

@Mockable
class NetworkManager<T> (val call:Call<T> )  {


    fun setOnStartNetworkListener(mNetworkCallbackListener: NetworkCallbackListener<T> ){
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {

                System.out.println()
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        mNetworkCallbackListener.onResponse(response.body() as T)
                    } else {
                        mNetworkCallbackListener.onFailure("요청은 성공했으나, 응답 데이터가 없음.")
                    }
                } else {
                    mNetworkCallbackListener.onFailure("요청은 성공했으나, 서버 개발자의 의도에 의한 Error 처리.")
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                mNetworkCallbackListener.onFailure(t.message.toString())
            }
        })
    }
}