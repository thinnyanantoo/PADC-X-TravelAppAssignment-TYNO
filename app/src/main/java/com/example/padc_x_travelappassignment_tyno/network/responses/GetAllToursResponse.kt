package com.example.padc_x_travelappassignment_tyno.network.responses

import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.CODE_RESPONSE_OK
import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.google.gson.annotations.SerializedName

class GetAllToursResponse (
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<TourVO>
    ){
        fun isResponseOk(): Boolean = (data != null) && (code == CODE_RESPONSE_OK)
    }
