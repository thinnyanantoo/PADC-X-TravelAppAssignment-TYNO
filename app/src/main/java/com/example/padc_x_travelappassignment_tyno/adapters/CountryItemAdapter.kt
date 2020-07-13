package com.example.padc_x_travelappassignment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.delegates.TravelDelegate
import com.example.padc_x_travelappassignment_tyno.viewHolders.CountryViewHolder


class CountryItemAdapter(delegate: TravelDelegate): BaseRecyclerAdapter<CountryViewHolder,TourVO>() {
    var mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view, mDelegate)
    }

}


