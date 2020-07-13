package com.example.padc_x_travelappassignment_tyno.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotoViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
        Glide.with(itemView.context)
            .load(data)
            .into(itemView.ivPhotoItem)
    }
}