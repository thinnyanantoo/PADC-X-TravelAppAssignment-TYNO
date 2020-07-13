package com.example.padc_x_travelappassignment_tyno.data.models
import androidx.lifecycle.LiveData
import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
import com.example.padc_x_travelappassignment_tyno.data.vos.TourAndCountryVO
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import io.reactivex.Observable

interface TourModel {
   fun getAllCountries(onError : (String) -> Unit) : List<TourVO>
    fun getAllTours(onError: (String) -> Unit) : List<TourVO>
    fun getCountryDetail(name : String) : LiveData<CountriesVo>
    fun tourDetail(name : String ) : LiveData<TourVO>

    fun combined() : Observable<TourAndCountryVO>
//    fun getAllTours(
//        onSuccess: (List<CountriesVo>) -> Unit,
//        onFailure: (String) -> Unit
//    )
}