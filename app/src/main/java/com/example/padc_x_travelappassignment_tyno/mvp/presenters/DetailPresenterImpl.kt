package com.example.padc_x_travelappassignment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_x_travelappassignment_tyno.TourApp
import com.example.padc_x_travelappassignment_tyno.data.models.TourModelImpl
import com.example.padc_x_travelappassignment_tyno.data.models.TourModel
import com.example.padc_x_travelappassignment_tyno.mvp.views.DetailView

class DetailPresenterImpl  : DetailPresenter, AbstractBasePresenter<DetailView>(){

    private val tourModel : TourModel =
        TourModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, name: String, type: Int) {
        if(type == 2) tourModel.tourDetail(name).observe(lifecycleOwner, Observer {
            mView?.showDetail(it)
        })
        else tourModel.getCountryDetail(name).observe(lifecycleOwner, Observer {
            mView?.countryDetail(it)
        })
    }
}