package jo.kotlin.mvpsample

/**
 * Created by Jo on 2018. 3. 26.
 */

class HomePresenter (val view: MainContract.View) : MainContract.Presenter{

    override fun loadFlickrPhotos() {

        view.showProgress()


    }

}