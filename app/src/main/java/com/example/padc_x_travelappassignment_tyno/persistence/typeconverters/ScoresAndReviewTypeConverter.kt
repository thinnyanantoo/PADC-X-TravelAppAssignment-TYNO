package com.example.padc_x_travelappassignment_tyno.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.padc_x_travelappassignment_tyno.data.vos.ScoresAndReviewsVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoresAndReviewTypeConverter {
    @TypeConverter
    fun toJsonString(list : List<ScoresAndReviewsVO>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(jsonString : String) : List<ScoresAndReviewsVO>{
        val type = object : TypeToken<List<ScoresAndReviewsVO>>(){}.type
        return  Gson().fromJson(jsonString,type)
    }
}