package com.example.padc_x_travelappassignment_tyno.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.persistence.daos.CountryDao
import com.example.padc_x_travelappassignment_tyno.persistence.daos.TourDao
import com.example.padc_x_travelappassignment_tyno.persistence.typeconverters.PhotoTypeConverter
import com.example.padc_x_travelappassignment_tyno.persistence.typeconverters.ScoresAndReviewTypeConverter

@Database(entities = [TourVO::class,CountriesVo::class],version = 2,exportSchema = false)
@TypeConverters(PhotoTypeConverter::class, ScoresAndReviewTypeConverter::class)
abstract class TourDb : RoomDatabase(){

    abstract fun tourDao() : TourDao

    abstract fun countryDao() : CountryDao

    companion object{
        val DB_NAME = "TOURS_AND_COUNTRIES.DB"
        var dbInstance : TourDb? = null
        fun getInstance(context: Context) : TourDb{
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(context,TourDb::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance!!
        }
    }

}