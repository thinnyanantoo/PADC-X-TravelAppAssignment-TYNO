package com.example.padc_x_travelappassignment_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO

@Dao
interface TourDao {
    @Query("select * from tours ")
    fun getAllTours() : List<TourVO>

    @Query("select * from tours where name = :note")
    fun getTourByName(note: String) : LiveData<TourVO>

    @Insert(entity = TourVO::class,onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTours(list : List<TourVO>)

    @Insert
    fun insertTours(noteVO: TourVO)

    @Query("select * from tours where name =:name ")
    fun getTourDetail(name: String) : LiveData<TourVO>

    @Query("delete from tours")
    fun deleteAllTours()

}