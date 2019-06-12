package com.treehouse.showif.home
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.treehouse.showif.App
import com.treehouse.showif.R
import com.treehouse.showif.home.di.DaggerHomeComponent
import com.treehouse.showif.home.di.HomeModule
import com.treehouse.showif.model.PhotoData
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val photoAdapter = PhotoAdapter()
    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        val layoutManager = LinearLayoutManager(this)

        rvData.layoutManager = layoutManager
        rvData.addItemDecoration(DividerItemDecoration
            (this,layoutManager.orientation))
        rvData.adapter = photoAdapter

        btnShowTheAvatar.setOnClickListener {
            homePresenter.getPhotoDetails(edUserName.text.toString()) }
    }
    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()}

    override fun showResults(result: List<PhotoData>) {
        photoAdapter.setData(result)
    }
     }
