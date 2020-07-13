package com.example.padc_x_travelappassignment_tyno.data.vos

import com.google.gson.annotations.SerializedName

class DataVO (
    @SerializedName("country")val country:List<TourVO>,
    @SerializedName("popular_tours")val popularTours:List<TourVO>
    )