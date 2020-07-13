package com.mhst.architectureassignment.views.viewpods

import android.content.Context


import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.padc_x_travelappassignment_tyno.R
import kotlinx.android.synthetic.main.service_in_detail_activity.view.*

class FavViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setValues(score : Float, color : Int = ContextCompat.getColor(context, R.color.colorPrimary)){
        tvReviewRate.text = score.toString()
        //vpFav.setBackgroundColor(color)
       // vpFav.setBackgroundDrawable(drawable)
    }

}