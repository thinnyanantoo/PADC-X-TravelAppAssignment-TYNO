package com.example.padc_x_travelappassignment_tyno.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.padc_x_travelappassignment_tyno.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>,ViewModel() {

    var mView : T? = null

    override fun initPresenter(view: T) {
        mView = view
    }


}