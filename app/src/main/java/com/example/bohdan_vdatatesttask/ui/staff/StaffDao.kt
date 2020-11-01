package com.example.bohdan_vdatatesttask.ui.staff

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StaffDao {
    @get:Query("SELECT * FROM staff_info") val allStaff: LiveData<List<StaffInfo>>
    @Query("DELETE FROM staff_info") suspend fun deleteAll()
    @Query("DELETE FROM staff_info where id = :id") suspend fun deleteById(id: Long)
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insert(company: StaffInfo): Long
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insert(vararg company: StaffInfo)
}