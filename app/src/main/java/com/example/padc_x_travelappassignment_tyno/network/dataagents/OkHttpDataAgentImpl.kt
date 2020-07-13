//package com.example.padc_x_travelappassignment_tyno.network.dataagents
//import android.os.AsyncTask
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.BASE_URL
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.GET_COUNTRY
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.PARAM_ACCESS_TOKEN
//import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
//import com.example.padc_x_travelappassignment_tyno.network.responses.GetAllToursResponse
//import com.google.gson.Gson
//import okhttp3.FormBody
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import java.lang.Exception
//import java.util.concurrent.TimeUnit
//
//object OkHttpDataAgentImpl :
//    TravelDelegate {
////    override fun getAllTours(
////        accessToken: String,
////        onSuccess: (List<CountriesVo>) -> Unit,
////        onFailure: (String) -> Unit
////    ) {
////        GetToursTask(
////            mokHttpClient = mClient,
////            mAccessToken = accessToken,
////            onSuccess = onSuccess,
////            onFailure = onFailure
////        ).execute()
////    }
//
//    private val mClient = OkHttpClient.Builder()
//        .connectTimeout(15, TimeUnit.SECONDS)
//        .readTimeout(15, TimeUnit.SECONDS)
//        .writeTimeout(15, TimeUnit.SECONDS)
//        .build()
//
//    override fun getAllCountry(
//        accessToken: String,
//        onSuccess: (List<CountriesVo>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        GetToursTask(
//            mokHttpClient = mClient,
//            mAccessToken = accessToken,
//            onSuccess = onSuccess,
//            onFailure = onFailure
//        ).execute()
//    }
//
//    class GetToursTask(
//        private val mokHttpClient: OkHttpClient,
//        private val mAccessToken: String,
//        private val onSuccess: (List<CountriesVo>) -> Unit,
//        private val onFailure: (String) -> Unit
//    ) : AsyncTask<Void, Void, GetAllToursResponse>() {
//        override fun doInBackground(vararg params: Void?): GetAllToursResponse? {
//            val formBody = FormBody.Builder()
//                .add(PARAM_ACCESS_TOKEN, mAccessToken)
//                .build()
//
//            val request = Request.Builder()
//                .url(BASE_URL + GET_COUNTRY)
//                .post(formBody)
//                .build()
//
//            try {
//                val response = mokHttpClient
//                    .newCall(request)
//                    .execute()
//
//                if (response.isSuccessful) {
//                    response.body?.let {
//                        val responseString = it.string()
//                        return Gson().fromJson<GetAllToursResponse>(
//                            responseString,
//                            GetAllToursResponse::class.java
//
//                        )
//                    }
//                }
//
//            } catch (e: Exception) {
//            }
//            return null
//        }
//
//        override fun onPostExecute(result: GetAllToursResponse?) {
//            if (result != null) {
//                // if(result.data != null && result.code == 200){
//                if (result.isResponseOk())
//                //        onSuccess(result?.data?.toList() ?: arrayListOf())   // list is null
//                    result.data?.let {
//                        onSuccess(it.toList())
//                    }
//                else {
//                    onFailure(result.message)
//                }
//            } else {
//                onFailure(ConstUtil.EM_NO_INTERNET_CONNECTION)
//            }
//        }
//    }
//}
//
//
//
