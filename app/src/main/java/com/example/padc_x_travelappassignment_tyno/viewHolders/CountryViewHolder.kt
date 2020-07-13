package com.example.padc_x_travelappassignment_tyno.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.delegates.TravelDelegate
import kotlinx.android.synthetic.main.item_country.view.*

class CountryViewHolder(itemView: View,private val delegate: TravelDelegate) : BaseViewHolder<TourVO>(itemView){
    override fun bindData(data: TourVO) {

        itemView.countryTitle.text = data.name

        itemView.countryRate.text = data.averageRating.toString()

        itemView.countryPlace.text = data.location

        Glide.with(itemView.context)
            .load(data.photo)
            .into(itemView.ivCountry)

        itemView.setOnClickListener {
             delegate.onTap(data.name)
        }
    }

}
