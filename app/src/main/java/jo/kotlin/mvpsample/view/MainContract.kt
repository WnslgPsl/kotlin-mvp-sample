package jo.kotlin.mvpsample

/**
 * Created by Jo on 2018. 3. 26.
 */

interface MainContract {

    interface View{
        fun hideProgress()
        fun showProgress()
    }

    interface Presenter{
        fun loadFlickrPhotos()
    }
}