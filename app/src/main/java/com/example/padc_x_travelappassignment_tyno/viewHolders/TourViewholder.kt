package com.example.padc_x_travelappassignment_tyno.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.delegates.TravelDelegate
import kotlinx.android.synthetic.main.item_popular_tours.view.*

class TourViewholder(itemView : View, private val mDelegate : TravelDelegate) : BaseViewHolder<TourVO>(itemView){
    override fun bindData(data: TourVO) {

        itemView.tvPopularCountry.text = data.name
        itemView.tvPopularRate.text = data.averageRating.toString()
        itemView.tvPopularLocation.text = data.location

        Glide.with(itemView.context)
            .load(data.photo)
            .into(itemView.ivBgPopular)

        itemView.setOnClickListener {
            mDelegate.onTap(data.name)
        }

    }

}