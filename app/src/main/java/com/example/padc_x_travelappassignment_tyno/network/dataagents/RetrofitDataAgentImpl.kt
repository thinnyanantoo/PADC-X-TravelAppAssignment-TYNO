//package com.example.padc_x_travelappassignment_tyno.network.dataagents
//
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.BASE_URL
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.EM_NO_INTERNET_CONNECTION
//import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
//import com.example.padc_x_travelappassignment_tyno.network.TravelApi
//import com.example.padc_x_travelappassignment_tyno.delegates.TravelDelegate
//import com.example.padc_x_travelappassignment_tyno.network.responses.GetAllToursResponse
//import okhttp3.OkHttpClient
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//object RetrofitDataAgentImpl :
//    TravelDelegate {
//
//    private var mCountryApi : TravelApi? = null
//
//    init {
//        val mOkHttpClient = OkHttpClient.Builder()
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(15,TimeUnit.SECONDS)
//            .writeTimeout(15,TimeUnit.SECONDS)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(mOkHttpClient)
//            .build()
//
//        mCountryApi = retrofit.create(TravelApi::class.java)
//    }
//    override fun getAllCountry(
//        accessToken: String,
//        onSuccess: (List<CountriesVo>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        val getAllCountryCall =mCountryApi?.getAllCountry(accessToken = accessToken)
//        getAllCountryCall?.enqueue(
//            object : Callback<GetAllToursResponse> {
//                override fun onResponse(
//                    call: Call<GetAllToursResponse>,
//                    response: Response<GetAllToursResponse>
//                ) {
//                  val getAllToursResponse =response.body()
//                    if(getAllToursResponse != null){
//                        if(getAllToursResponse.isResponseOk()){
//                            getAllToursResponse.data?.let{
//                                onSuccess(it)
//                            }
//                        }else {
//                            onFailure(getAllToursResponse.message)
//                        }
//                    }else{
//                        onFailure(EM_NO_INTERNET_CONNECTION)
//                    }
//                }
//
//                override fun onFailure(call: Call<GetAllToursResponse>, t: Throwable) {
//                  onFailure(t.message?: EM_NO_INTERNET_CONNECTION)
//                }
//            }
//        )
//    }
//
//}