package com.example.bohdan_vdatatesttask.ui.comp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CompanyDao {
    @get:Query("SELECT * FROM comp_info") val allComp: LiveData<List<CompanyInfo>>
    @Query("DELETE from comp_info where comp_name = :name") suspend fun delete(name: String): Int
    @Query("DELETE from comp_info") suspend fun deleteAll(): Int
    @Query("SELECT * FROM comp_info where id = :id LIMIT 1") suspend fun getCompById(id: Long): CompanyInfo
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insert(company: CompanyInfo): Long
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insert(vararg company: CompanyInfo)
}