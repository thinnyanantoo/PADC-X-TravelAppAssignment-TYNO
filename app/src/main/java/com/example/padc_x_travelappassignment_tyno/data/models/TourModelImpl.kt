package com.example.padc_x_travelappassignment_tyno.data.models

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.padc_x_travelappassignment_tyno.TourApp.Companion.context
import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
import com.example.padc_x_travelappassignment_tyno.data.vos.TourAndCountryVO
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.network.responses.GetAllToursResponse
import com.example.padc_x_travelappassignment_tyno.persistence.db.TourDb
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object TourModelImpl: TourModel, BaseModels() {
     lateinit var mDataBase : TourDb

    var errorMessage = " Error"
    var list = MutableLiveData<TourAndCountryVO>()
    private var db = TourDb.getInstance(context)

    override fun getAllCountries(onError: (String) -> Unit): List<TourVO> {
        onError(errorMessage)
        return db.countryDao().getAllTCountries()
    }

    override fun getAllTours(onError: (String) -> Unit): List<TourVO> {
        onError(errorMessage)
        return db.tourDao().getAllTours()
    }

    override fun getCountryDetail(name: String): LiveData<CountriesVo> {
        return db.countryDao().getCountryDetail(name)
    }

    override fun tourDetail(name: String): LiveData<TourVO> {
        return db.tourDao().getTourDetail(name)
    }

    override fun combined(): Observable<TourAndCountryVO> {
        var d = Log.d("combine", "combination is started")

        return Observable.zip(travelApi!!.getAllTours(), this.travelApi!!.getAllCountried(),
            BiFunction<GetAllToursResponse,GetAllToursResponse,TourAndCountryVO> { tours : GetAllToursResponse, countries : GetAllToursResponse ->

                db.countryDao().deleteAllCountries()
                db.tourDao().deleteAllTours()
                tours.data.let { db.tourDao().insertAllTours(it )}
                countries.data.let { db.countryDao().insertAllCountries(it)}
                val countries = db.countryDao().getAllTCountries()
                val tours = db.tourDao().getAllTours()
                return@BiFunction TourAndCountryVO(countries, tours)
            }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }




}




