package jo.kotlin.mvpsample

/**
 * Created by Jo on 2018. 3. 26.
 */

interface MainContract {

    interface View{
        fun hideProgress()
        fun showProgress()
        fun showMessage(msg: String)
        fun showDetailInfo(title: String)
    }

    interface Presenter{
        fun loadFlickrPhotos()
    }
}