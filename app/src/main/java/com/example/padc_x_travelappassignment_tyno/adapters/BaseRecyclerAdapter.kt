package com.example.padc_x_travelappassignment_tyno.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.padc_x_travelappassignment_tyno.viewHolders.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>,W> : RecyclerView.Adapter<T>(){

  var mData: MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }
    fun setNewData(data : MutableList<W>){
        if (data.isEmpty()) {
            mData.clear()
        } else {
            mData = ArrayList(data)
        }
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if(position < mData.size)  mData[position] else null
    }

    fun getItems(): List<W> {
        return mData
    }

    fun clearData() {
        mData = arrayListOf()
        notifyDataSetChanged()
    }


}