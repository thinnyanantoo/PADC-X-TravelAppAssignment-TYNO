package com.example.padc_x_travelappassignment_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.padc_x_travelappassignment_tyno.data.vos.CountriesVo
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO

@Dao
interface CountryDao {
    @Query("select * from countries ")
    fun getAllTCountries() : List<TourVO>

    @Insert(entity = CountriesVo::class)
    fun insertAllCountries(list : List<TourVO>)

    @Query("select * from countries where name =:name")
    fun getCountryDetail(name: String) : LiveData<CountriesVo>

    @Query("delete from countries")
    fun deleteAllCountries()
}