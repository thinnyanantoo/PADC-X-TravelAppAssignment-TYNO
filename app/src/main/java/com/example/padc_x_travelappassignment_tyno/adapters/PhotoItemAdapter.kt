package com.example.padc_x_travelappassignment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.viewHolders.PhotoViewHolder

class PhotoItemAdapter: BaseRecyclerAdapter<PhotoViewHolder,String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item,parent,false)
        return PhotoViewHolder(view)
    }

}