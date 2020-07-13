package com.example.padc_x_travelappassignment_tyno.data.models

import android.content.Context
import com.example.padc_x_travelappassignment_tyno.TourApp.Companion.context
import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.BASE_URL
import com.example.padc_x_travelappassignment_tyno.network.TravelApi
import com.example.padc_x_travelappassignment_tyno.persistence.db.TourDb
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


abstract class BaseModels {
    protected lateinit var travelApi : TravelApi
    protected lateinit var mTheDB : TourDb

    init {
        val interceptor = HttpLoggingInterceptor()

        interceptor.level  = HttpLoggingInterceptor.Level.BASIC

      val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpBuilder)
            .build()

       // travelApi = retrofit.create(TravelApi::class.java)
        travelApi = retrofit.create(TravelApi::class.java)

    }
    fun initDB(context: Context){
        TourModelImpl.mDataBase = TourDb.getInstance(context)
    }


}