package jo.kotlin.mvpsample.network.retrofit

/**
 * Created by Jo on 2018. 4. 2.
 */

interface NetworkCallbackListener<T> {

    fun onResponse(t: T)
    fun onFailure(msg: String)

}