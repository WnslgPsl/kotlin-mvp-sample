package jo.kotlin.mvpsample.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jo.kotlin.mvpsample.R
import jo.kotlin.mvpsample.util.CustomRecyclerViewHolder
import jo.kotlin.mvpsample.view.adapter.viewholder.MainPhotoViewHolder
import jo.kotlin.mvpsample.view.data.Photo

/**
 * Created by Jo on 2018. 3. 29.
 */

class MainRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<CustomRecyclerViewHolder<ArrayList<Photo>>>(),
        MainAdapterContract.View, MainAdapterContract.Model {

    private var items = arrayListOf<Photo>()
    override lateinit var onItemClicked: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerViewHolder<ArrayList<Photo>> {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.main_photo_item, parent, false)
        return MainPhotoViewHolder(v, onItemClicked)
    }

    override fun onBindViewHolder(holder: CustomRecyclerViewHolder<ArrayList<Photo>>, position: Int) {
        if (holder is MainPhotoViewHolder) {
            holder.bind(items, position)
        }

    }

    override fun getItemCount(): Int {
        return if (items.size > 0) items.size else 0
    }

    override fun updateView() {
        notifyDataSetChanged()
    }

    override fun addItems(photos: ArrayList<Photo>) {
        items.addAll(photos)
    }

    override fun getItem(position: Int): Photo = items.get(position)

}