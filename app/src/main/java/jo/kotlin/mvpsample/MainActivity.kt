package jo.kotlin.mvpsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import jo.kotlin.mvpsample.view.adapter.MainRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.channels.Selector

class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter: HomePresenter by lazy {
        HomePresenter(this@MainActivity)
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
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
