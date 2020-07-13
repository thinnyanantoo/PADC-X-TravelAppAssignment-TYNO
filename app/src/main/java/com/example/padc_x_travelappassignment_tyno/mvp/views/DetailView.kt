package com.example.padc_x_travelappassignment_tyno.mvp.views

import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO

interface DetailView :BaseView {
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun showDetail(detailObj : TourVO)
    fun countryDetail(detailObj : CountriesVo)
    fun showEmptyView()
    fun hideEmptyView()
}