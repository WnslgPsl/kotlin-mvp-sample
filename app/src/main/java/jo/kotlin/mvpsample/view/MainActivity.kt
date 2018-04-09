package jo.kotlin.mvpsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import jo.kotlin.mvpsample.network.retrofit.createRetrofit
import jo.kotlin.mvpsample.remote.MainRepository
import jo.kotlin.mvpsample.util.NetworkDialog
import jo.kotlin.mvpsample.view.adapter.MainRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.channels.Selector

class MainActivity : AppCompatActivity(), MainContract.View {

    private val networkDialog: NetworkDialog by lazy {
        NetworkDialog(this@MainActivity)
    }

    private val presenter: HomePresenter by lazy {
        HomePresenter(this@MainActivity, MainRepository, mainAdapter, mainAdapter)
    }

    private val mainAdapter: MainRecyclerAdapter by lazy {
        MainRecyclerAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView(){
        mainRecyclerView.run {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mainAdapter

        }

        presenter.loadFlickrPhotos()
    }

    override fun showProgress() {
        if (!networkDialog.isShowing) networkDialog.showNetworkDialog()
    }

    override fun hideProgress() {
        if(networkDialog.isShowing) networkDialog.dismissNetworkDialog()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showDetailInfo(title: String) {
        Toast.makeText(this@MainActivity, title, Toast.LENGTH_SHORT).show()
    }
}
