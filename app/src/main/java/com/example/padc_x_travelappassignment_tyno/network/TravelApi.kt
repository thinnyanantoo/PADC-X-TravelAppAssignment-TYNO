package com.example.padc_x_travelappassignment_tyno.network


import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.GET_COUNTRIES
import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.GET_TOURS
import com.example.padc_x_travelappassignment_tyno.network.responses.GetAllToursResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface TravelApi {

    @GET(GET_TOURS)
   fun getAllTours(): Observable<GetAllToursResponse>

    @GET(GET_COUNTRIES)
    fun getAllCountried() : Observable<GetAllToursResponse>


}