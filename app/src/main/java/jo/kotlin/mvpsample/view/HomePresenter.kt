package jo.kotlin.mvpsample

import android.util.Log
import jo.kotlin.mvpsample.remote.MainDataSource
import jo.kotlin.mvpsample.remote.MainRepository
import jo.kotlin.mvpsample.view.adapter.MainAdapterContract
import jo.kotlin.mvpsample.view.data.PhotoResponse
import java.util.*

/**
 * Created by Jo on 2018. 3. 26.
 */

class HomePresenter(val view: MainContract.View, val mainRepository: MainRepository,
                    val adapterView: MainAdapterContract.View,
                    val adapterModel: MainAdapterContract.Model) : MainContract.Presenter {

    init {
        adapterView.onItemClicked = {
            view.showDetailInfo(adapterModel.getItem(it).title)
        }
    }

    override fun loadFlickrPhotos() {

        view.showProgress()

        mainRepository.getSearchPhotos("json", "1",
                "flickr.photos.search", "LOVE", BuildConfig.FLICKR_API_KEY, 1,
                200, object : MainDataSource.LoadFlickrCallback<PhotoResponse> {

            override fun onSuccess(photoResponse: PhotoResponse) {
                view.hideProgress()

                val stat = photoResponse?.stat

                if(stat.equals("ok")){
                    Log.d("seongjun", stat);
                    adapterModel.addItems(photoResponse.photos.photo)
                    adapterView.updateView()
                }else{
                    view.showMessage("stat : $stat")
                }
            }

            override fun onFailure(message: String) {
                view.hideProgress()
                view.showMessage("Failure : $message")
            }

        })

    }

}