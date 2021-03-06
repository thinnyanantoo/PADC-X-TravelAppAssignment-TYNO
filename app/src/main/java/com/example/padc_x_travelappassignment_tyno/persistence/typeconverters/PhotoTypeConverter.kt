package com.example.padc_x_travelappassignment_tyno.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoTypeConverter {
    @TypeConverter
    fun toList(jsonString : String) : List<String>{
        return Gson().fromJson(jsonString,object : TypeToken<List<String>>(){}.type)
    }

    @TypeConverter
    fun toJsonString(list : List<String>) : String{
        return Gson().toJson(list)
    }
}