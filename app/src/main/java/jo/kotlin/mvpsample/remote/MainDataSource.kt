package jo.kotlin.mvpsample.remote

import jo.kotlin.mvpsample.view.data.PhotoResponse

/**
 * Created by Jo on 2018. 3. 29.
 */

interface MainDataSource {

    interface LoadFlickrCallback<T> {
        fun onSuccess(t: T)
        fun onFailure(message: String)
    }

    fun getSearchPhotos(format: String, nojsoncallback: String, method: String, searchKeyword: String, flickrKey: String, requestPage: Int,
                                 requestPerPage: Int, callback: LoadFlickrCallback<PhotoResponse>)
}