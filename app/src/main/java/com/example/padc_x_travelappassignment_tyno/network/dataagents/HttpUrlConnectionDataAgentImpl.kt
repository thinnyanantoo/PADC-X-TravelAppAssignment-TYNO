//package com.example.padc_x_travelappassignment_tyno.network.dataagents
//
//import android.os.AsyncTask
//import android.util.Log
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.BASE_URL
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.EM_NO_INTERNET_CONNECTION
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.GET_COUNTRY
//import com.example.padc_x_travelappassignment_tyno.Util.ConstUtil.Companion.PARAM_ACCESS_TOKEN
//import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
//import com.example.padc_x_travelappassignment_tyno.network.responses.GetAllToursResponse
//import com.google.gson.Gson
//import org.apache.http.NameValuePair
//import org.apache.http.message.BasicNameValuePair
//import java.io.*
//import java.lang.Exception
//import java.lang.StringBuilder
//import java.net.HttpURLConnection
//import java.net.URL
//import java.net.URLEncoder
//
//object HttpUrlConnectionDataAgentImpl :
//    TravelDelegate {
////    override fun getAllTours(
////        accessToken: String,
////        onSuccess: (List<CountriesVo>) -> Unit,
////        onFailure: (String) -> Unit
////    ) {
////        GetToursTask(
////        accessToken = accessToken,
////        onSuccess = onSuccess,
////        onFailure = onFailure).execute()
////    }
//
//    override fun getAllCountry(
//        accessToken: String,
//        onSuccess: (List<CountriesVo>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        GetToursTask(
//            accessToken = accessToken,
//            onSuccess = onSuccess,
//            onFailure = onFailure
//        ).execute()
//
//    }
//
//    class GetToursTask(
//        val accessToken: String,
//        val onSuccess: (List<CountriesVo>) -> Unit,
//        val onFailure: (String) -> Unit
//    ) :
//        AsyncTask<Void, Void, GetAllToursResponse>() {
//        override fun doInBackground(vararg params: Void?): GetAllToursResponse? {
//            val url: URL
//            var reader: BufferedReader? = null
//            val stringBuilder: StringBuilder
//
//            try {
//                url = URL(BASE_URL + GET_COUNTRY)
//
//                val connection = url.openConnection() as HttpURLConnection //2
//
//                //just want to do an HTTP POst here
//                connection.requestMethod = "POST" // 3
//
//                //give it 15 seconds to respond
//                connection.readTimeout = 15 * 1000 //4. ms
//
//                connection.doInput = true //5.
//                connection.doOutput = true
//
//                val params = ArrayList<NameValuePair>() //6
//                params.add(
//                    BasicNameValuePair(
//                        PARAM_ACCESS_TOKEN,
//                        accessToken
//                    )
//                )
//                //write the parameters from NameValuePair list into connection obj
//                val outputStream = connection.outputStream
//                val writer = BufferedWriter(
//                    OutputStreamWriter(outputStream, "UTF-8")
//                )
//                writer.write(getQuery(params))
//                writer.flush()
//                writer.close()
//                outputStream.close()
//                connection.connect() // 7
//
//                //read the output from the server
//                reader = BufferedReader(
//                    InputStreamReader(connection.inputStream)
//                )//
//                stringBuilder = StringBuilder()
//
//                for (line in reader.readLines()) {
//                    stringBuilder.append(line + "/n")
//                }
//                val responseString = stringBuilder.toString()
//                return Gson()
//                    .fromJson<GetAllToursResponse>(
//                    responseString,
//                    GetAllToursResponse::class.java
//                )
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//                Log.e("NewsError", e.message ?: "")
//            } finally {
//                //close the reader: this can throw and exception too, so
//                //wrap it in andother try/catch block.
//                if (reader != null) {
//                    try {
//                        reader.close()
//                    } catch (ioe: IOException) {
//                        ioe.printStackTrace()
//                    }
//                }
//            }
//            return null
//        }
//
//
//        @Throws(UnsupportedEncodingException::class)
//        private fun getQuery(params: List<NameValuePair>): String {
//            val result = StringBuilder()
//            var first = true
//
//            for (pair in params) {
//                if (first)
//                    first = false
//                else
//                    result.append("&")
//
//                result.append(URLEncoder.encode(pair.getName(), "UTF-8"))
//                result.append("=")
//                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"))
//            }
//            return result.toString()
//        }
//
//        override fun onPostExecute(result: GetAllToursResponse?) {
//            super.onPostExecute(result)
//            if(result != null){
//                if(result.isResponseOk())
//                    result.data?.let{
//                        onSuccess(it.toList())
//                    }
//                else{
//                    onFailure(result.message)
//                }
//            }
//            else{
//                onFailure(EM_NO_INTERNET_CONNECTION)
//            }
//        }
//    }
//
//
//}
