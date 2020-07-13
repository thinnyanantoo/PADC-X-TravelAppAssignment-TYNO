package com.example.padc_x_travelappassignment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_x_travelappassignment_tyno.TourApp

import com.example.padc_x_travelappassignment_tyno.data.models.TourModel
import com.example.padc_x_travelappassignment_tyno.data.models.TourModelImpl
import com.example.padc_x_travelappassignment_tyno.mvp.views.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl : MainPresenter , AbstractBasePresenter<MainView>(){

    var model: TourModel = TourModelImpl


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestAllData(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
      requestAllData(lifecycleOwner)
    }
    override fun onTap(name: String) {
        mView?.navigateDetail(name)
    }


    private fun requestAllData(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        model.combined()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                mView?.showErrorMessage(it.localizedMessage) }
            .subscribe {
                mView?.disableSwipeRefresh()
                if (it.countries.isEmpty() && it.tours.isEmpty())
                    mView?.displayEmptyView()
                else mView?.showList(it)
            }
    }


}