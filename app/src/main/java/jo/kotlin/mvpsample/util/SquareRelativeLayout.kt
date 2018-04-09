package jo.kotlin.mvpsample.util

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

/**
 * Created by Jo on 2018. 4. 3.
 */

class SquareRelativeLayout constructor(context: Context) : RelativeLayout(context) {

    constructor(context: Context, attrs: AttributeSet) : this(context)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs)


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}