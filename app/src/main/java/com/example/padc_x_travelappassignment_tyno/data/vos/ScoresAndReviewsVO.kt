package com.example.padc_x_travelappassignment_tyno.data.vos

import com.google.gson.annotations.SerializedName

class ScoresAndReviewsVO(
    @SerializedName("name")val name : String = "",
    @SerializedName("score")val score : Int = 0,
    @SerializedName("max_score")val maxScroes : Int = 0,
    @SerializedName("total_reviews")val totalReviews : Int = 0
)