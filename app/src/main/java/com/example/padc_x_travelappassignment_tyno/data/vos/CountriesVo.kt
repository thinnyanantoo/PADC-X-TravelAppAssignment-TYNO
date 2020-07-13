package com.example.padc_x_travelappassignment_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_x_travelappassignment_tyno.persistence.typeconverters.PhotoTypeConverter
import com.example.padc_x_travelappassignment_tyno.persistence.typeconverters.ScoresAndReviewTypeConverter
import com.google.gson.annotations.SerializedName

@TypeConverters(PhotoTypeConverter::class, ScoresAndReviewTypeConverter::class)
@Entity(tableName = "countries")
data class CountriesVo (
    @PrimaryKey
    @SerializedName("name")val name : String = "",
    @SerializedName("description")val description : String = "",
    @SerializedName("location")val location : String = "",
    @SerializedName("average_rating")val averageRating : Float = 0F,
    @SerializedName("scores_and_reviews")val scoresAndReviews:List<ScoresAndReviewsVO> = listOf(),
    @SerializedName("photos")val photo:List<String> = listOf()
)

