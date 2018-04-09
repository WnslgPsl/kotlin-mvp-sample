package jo.kotlin.mvpsample.view.adapter

import jo.kotlin.mvpsample.view.data.Photo

/**
 * Created by Jo on 2018. 4. 5.
 */

interface MainAdapterContract {

    interface View {
        fun updateView()
        var onItemClicked: (Int) -> Unit
    }

    interface Model {
        fun addItems(photos: ArrayList<Photo>)
        fun getItem(position: Int): Photo
    }
}