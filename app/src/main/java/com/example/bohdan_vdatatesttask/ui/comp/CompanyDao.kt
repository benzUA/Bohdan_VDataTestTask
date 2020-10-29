package com.example.bohdan_vdatatesttask.ui.comp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CompanyDao {
    @Query("SELECT * FROM comp_info") fun getAll(): List<CompanyInfo>
    @Query("DELETE from comp_info where comp_name = :name") fun delete(name: String)
    @Insert fun insert(company: CompanyInfo)
}