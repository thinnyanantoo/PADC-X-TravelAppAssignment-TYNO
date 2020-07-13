package com.example.padc_x_travelappassignment_tyno

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.padc_x_travelappassignment_tyno.data.models.TourModel
import com.example.padc_x_travelappassignment_tyno.data.models.TourModelImpl


abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
        val mtourModel : TourModel = TourModelImpl
    }
