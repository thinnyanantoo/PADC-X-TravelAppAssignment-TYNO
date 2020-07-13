package com.example.padc_x_travelappassignment_tyno.mvp.views

import com.example.padc_x_travelappassignment_tyno.data.vos.TourAndCountryVO

interface MainView : BaseView{
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun showList(list : TourAndCountryVO)
    fun showErrorMessage(message : String)
    fun displayEmptyView()
    fun hideEmptyView()
    fun navigateDetail(name: String)
}