package com.example.padc_x_travelappassignment_tyno.mvp.presenters

import com.example.padc_x_travelappassignment_tyno.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun initPresenter(view : T)
}