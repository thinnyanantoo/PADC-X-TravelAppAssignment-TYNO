package com.example.padc_x_travelappassignment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_x_travelappassignment_tyno.mvp.views.MainView
import com.example.padc_x_travelappassignment_tyno.delegates.TravelDelegate

interface MainPresenter : BasePresenter<MainView>,
    TravelDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)

}