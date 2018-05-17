package jo.kotlin.mvpsample.remote

import jo.kotlin.mvpsample.BuildConfig
import jo.kotlin.mvpsample.network.retrofit.NetworkCallbackListener
import jo.kotlin.mvpsample.network.retrofit.NetworkManager
import jo.kotlin.mvpsample.network.retrofit.createRetrofit
import jo.kotlin.mvpsample.util.Mockable
import jo.kotlin.mvpsample.view.data.PhotoResponse

/**
 * Created by Jo on 2018. 4. 2.
 */

class RemoteDataSource : MainDataSource{


    override fun getSearchPhotos(format: String, nojsoncallback: String, method: String, searchKeyword: String,
                                 flickrKey: String, requestPage: Int, requestPerPage: Int,
                                 callback: MainDataSource.LoadFlickrCallback) {

        val call = createRetrofit().getFlickrSearch(format, nojsoncallback,
                method, flickrKey, searchKeyword, requestPage, requestPerPage)

        val networkManager = NetworkManager(call)
        networkManager.setOnStartNetworkListener(object : NetworkCallbackListener<PhotoResponse> {

            override fun onResponse(photoResponse: PhotoResponse){
                callback.onSuccess(photoResponse)
            }

            override fun onFailure(msg: String) {
                callback.onFailure(msg)
            }
        })
    }


}