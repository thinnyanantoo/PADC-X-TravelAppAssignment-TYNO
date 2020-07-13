package com.example.padc_x_travelappassignment_tyno.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {

    var mData : T? = null
    abstract fun bindData(data : T)
}