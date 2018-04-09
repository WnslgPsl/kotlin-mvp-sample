package jo.kotlin.mvpsample.util

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Jo on 2018. 4. 3.
 */

abstract class CustomRecyclerViewHolder<T> (itemView: View): RecyclerView.ViewHolder(itemView){

    abstract fun bind(item: T, position: Int)
}