package com.example.bohdan_vdatatesttask.ui.staff

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StaffDao {
    @Query("SELECT * FROM staff_info") fun getAll(): List<StaffInfo>
    @Insert fun insert(company: StaffInfo)
}