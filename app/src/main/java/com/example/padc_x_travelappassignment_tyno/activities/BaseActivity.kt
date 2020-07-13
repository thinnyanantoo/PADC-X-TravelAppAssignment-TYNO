package com.example.padc_x_travelappassignment_tyno.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


open class BaseActivity : AppCompatActivity() {

    fun showSnackBar(message : String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_SHORT).show()
    }

}