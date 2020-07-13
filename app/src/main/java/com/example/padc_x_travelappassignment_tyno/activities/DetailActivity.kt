package com.example.padc_x_travelappassignment_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.adapters.ItemScroeRateAdapter
import com.example.padc_x_travelappassignment_tyno.adapters.PhotoItemAdapter
import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.mvp.presenters.DetailPresenter
import com.example.padc_x_travelappassignment_tyno.mvp.presenters.DetailPresenterImpl
import com.example.padc_x_travelappassignment_tyno.mvp.views.DetailView
import com.example.padc_x_travelappassignment_tyno.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.item_country.*
import kotlinx.android.synthetic.main.item_popular_tours.*
import kotlinx.android.synthetic.main.photo_item.*
import kotlinx.android.synthetic.main.viewpod_empty.*

class DetailActivity : BaseActivity(), DetailView{
    lateinit var scoreAndRevieAdapter: ItemScroeRateAdapter
    lateinit var photoItemAdapter : PhotoItemAdapter
    lateinit var presenter : DetailPresenter

    override fun showEmptyView() {
        ivEmptyImage.visibility = View.VISIBLE
    }

    override fun hideEmptyView() {
       ivEmptyImage.visibility = View.GONE
    }

    private fun bindTour(data : TourVO){
        tvPopularCountry.text = data.name
        tvPopularLocation.text = data.location
        tvPopularRate.text = data.averageRating.toString()
        Glide.with(this)
            .load(data.photo[0])
            .into(ivPhotoItem)
        ratingBar.rating = data.averageRating
        scoreAndRevieAdapter.setNewData(data.scoresAndReviews.toMutableList())
        photoAdapter.setNewData(data.photo.toMutableList())
    }
    private fun bindCountries(data : CountriesVo){
        countryTitle.text = data.name
        countryPlace.text = data.location
        tvDetailText.text = data.description
        Glide.with(this)
            .load(data.photo[0])
            .into(ivMain)
        ratingBar.rating = data.averageRating
        scoreAndRevieAdapter.setNewData(data.scoresAndReviews.toMutableList())
        photoAdapter.setNewData(data.photo.toMutableList())

    }
    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
       swipeRefreshLayout.isRefreshing = false
    }

    override fun showDetail(detailObj: TourVO) {
        if(detailObj == null){
            showEmptyView()
        }else {
            hideEmptyView()
            bindTour(detailObj)
        }
    }

    override fun countryDetail(detailObj: CountriesVo) {
        if(detailObj == null)  {
            showEmptyView()
        }else {
            hideEmptyView()
            bindCountries(detailObj)
        }
    }

    lateinit var itemScoreAdapter : ItemScroeRateAdapter
    lateinit var photoAdapter: PhotoItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpPresenter()

        val name = intent.getStringExtra(DUMMY_NAME)
        val type = intent.getIntExtra(DUMMY_IDTYPE, 0)

        setupRecycler()
        presenter.onUiReady(this,name,type)
        ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecycler(){
        photoAdapter = PhotoItemAdapter()
        rvPhoto.adapter = photoAdapter

        itemScoreAdapter = ItemScroeRateAdapter()
        rvServiceScoreRage.adapter = itemScoreAdapter

    }

    private fun setUpPresenter(){
        presenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        presenter.initPresenter(this)
    }

    companion object {
        private const val DUMMY_NAME = "Name"
        private const val DUMMY_IDTYPE = "IdType"

        fun newInstance(context:Context, name : String) : Intent {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(DUMMY_NAME,name)
            return intent
        }
    }
}
