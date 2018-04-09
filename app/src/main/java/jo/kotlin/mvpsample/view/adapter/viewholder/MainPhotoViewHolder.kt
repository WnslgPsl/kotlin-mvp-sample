package jo.kotlin.mvpsample.view.adapter.viewholder

import android.view.View
import jo.kotlin.mvpsample.util.CustomRecyclerViewHolder
import jo.kotlin.mvpsample.util.GlideApp
import jo.kotlin.mvpsample.view.data.Photo
import kotlinx.android.synthetic.main.main_photo_item.view.*
import java.util.ArrayList

/**
 * Created by Jo on 2018. 4. 3.
 */
 
class MainPhotoViewHolder(itemView: View, onItemClicked: (Int) -> Unit) : CustomRecyclerViewHolder<ArrayList<Photo>>(itemView) {

    init {
        itemView.setOnClickListener { onItemClicked(adapterPosition) }
    }

    override fun bind(item: ArrayList<Photo>, position: Int) {
        itemView.run {
            GlideApp.with(this.context)
                    .load(item.get(position).getPhotoURL())
                    .centerCrop()
                    .into(iv_main_photo_item)
        }
    }

}