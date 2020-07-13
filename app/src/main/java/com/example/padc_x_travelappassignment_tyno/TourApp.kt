package com.example.padc_x_travelappassignment_tyno

import android.app.Application
import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.padc_x_travelappassignment_tyno.data.models.TourModelImpl

class TourApp : Application() {

    @Inject
companion object{
      lateinit  var context : Context
}

    override fun onCreate() {
        super.onCreate()
        TourModelImpl.initDB(applicationContext)
        getTourOneTime()


    }
    private fun getTourOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetTourWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }
}

annotation class Inject


