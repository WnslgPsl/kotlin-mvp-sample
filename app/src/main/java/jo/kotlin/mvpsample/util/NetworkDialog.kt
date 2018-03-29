package jo.kotlin.mvpsample.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.PopupWindow
import jo.kotlin.mvpsample.R

/**
 * Created by Jo on 2018. 3. 29.
 */
 
 class NetworkDialog constructor(context: Context) : Dialog(context) {

    init {
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.network_dialog)
        setCancelable(false)
    }

    fun showNetworkDialog(){
        if (!this.isShowing) this.show()
    }

    fun dismissNetworkDialog(){
        if (!this.isShowing) this.dismiss()
    }


}