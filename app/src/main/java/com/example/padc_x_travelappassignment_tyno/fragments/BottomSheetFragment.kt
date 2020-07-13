package com.example.padc_x_travelappassignment_tyno.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.RelativeLayout
import com.example.padc_x_travelappassignment_tyno.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class BottomSheetFragment : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.bottom_sheet, container, false)
        val sheet = BottomSheetBehavior.from(view)
        sheet.state = BottomSheetBehavior.STATE_EXPANDED
        return view
    }
}


