package com.example.padc_x_travelappassignment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.data.vos.ScoresAndReviewsVO
import com.example.padc_x_travelappassignment_tyno.viewHolders.ItemScroeRateViewHolder

class ItemScroeRateAdapter : BaseRecyclerAdapter<ItemScroeRateViewHolder,ScoresAndReviewsVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemScroeRateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_in_detail_activity,parent,false)
        return ItemScroeRateViewHolder(view)
    }

}