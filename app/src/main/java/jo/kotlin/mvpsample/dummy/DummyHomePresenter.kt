package jo.kotlin.mvpsample.dummy

import jo.kotlin.mvpsample.BuildConfig
import jo.kotlin.mvpsample.remote.MainDataSource
import jo.kotlin.mvpsample.remote.MainRepository
import jo.kotlin.mvpsample.util.Mockable
import jo.kotlin.mvpsample.view.data.PhotoResponse

/**
 * Created by Jo on 2018. 5. 16.
 */

@Mockable
class DummyHomePresenter(val mainRepository: MainRepository) {

    fun loadFlickrPhotos(loadFlickrCallback : MainDataSource.LoadFlickrCallback) {

        mainRepository.getSearchPhotos("json", "1",
                "flickr.photos.search", "LOVE", BuildConfig.FLICKR_API_KEY, 1,
                200, object : MainDataSource.LoadFlickrCallback {

            override fun onSuccess(photoResponse: PhotoResponse) {
                loadFlickrCallback.onSuccess(photoResponse)
            }

            override fun onFailure(message: String) {
                loadFlickrCallback.onFailure(message)
            }

        })
    }
}