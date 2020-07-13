package com.example.padc_x_travelappassignment_tyno.viewHolders

import android.view.View
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.data.vos.ScoresAndReviewsVO
import kotlinx.android.synthetic.main.service_in_detail_activity.view.*

class ItemScroeRateViewHolder(itemView: View) : BaseViewHolder<ScoresAndReviewsVO>(itemView) {
    override fun bindData(data: ScoresAndReviewsVO) {
        itemView.tvBookingName.text = data.name

        itemView.tvMaxScore.text= itemView.context.getString(R.string.txt_max_score,data.score,data.maxScroes)

        itemView.tvReviewRate.text = itemView.context.getString(R.string.txt_total_review,data.totalReviews)
    }

}