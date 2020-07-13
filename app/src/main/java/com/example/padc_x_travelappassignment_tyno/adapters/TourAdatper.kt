package com.example.padc_x_travelappassignment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.delegates.TravelDelegate
import com.example.padc_x_travelappassignment_tyno.viewHolders.TourViewholder

class TourAdatper(mDelegate: TravelDelegate):BaseRecyclerAdapter<TourViewholder,TourVO>() {
    var delegate = mDelegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_tours,parent,false)
        return TourViewholder(view,delegate)
    }
}