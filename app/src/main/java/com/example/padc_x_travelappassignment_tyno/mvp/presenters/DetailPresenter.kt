package com.example.padc_x_travelappassignment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_x_travelappassignment_tyno.mvp.views.DetailView

interface DetailPresenter : BasePresenter<DetailView>{
    fun onUiReady(lifecycleOwner: LifecycleOwner, name :String, type : Int)
}