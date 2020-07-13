package com.example.padc_x_travelappassignment_tyno

import android.content.Context
import androidx.work.WorkerParameters


class GetTourWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        var result = Result.failure()
        return result
    }
}