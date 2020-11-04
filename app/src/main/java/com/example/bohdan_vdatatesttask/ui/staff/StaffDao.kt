package com.example.bohdan_vdatatesttask.ui.staff

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StaffDao {
    @get:Query("SELECT * FROM staff_info") val allStaff: LiveData<List<StaffInfo>>

    @Query("DELETE FROM staff_info") suspend fun deleteAll()

    @Query("SELECT COUNT(staff_name) FROM staff_info where staff_comp = :id") suspend fun getStaffByComp(id: Long): Long

    @Query("SELECT staff_name, staff_surname, staff_date FROM staff_info where staff_comp = :id")
        suspend fun getStaffDateByComp(id: Long): List<StaffDateInfo>

    @Update(onConflict = OnConflictStrategy.IGNORE) suspend fun update(staff: StaffInfo)

    @Query("UPDATE staff_info SET staff_name = :name, staff_surname = :surname, staff_comp = :comp, staff_pic = :pic WHERE id = :id")
        suspend fun updateById(name: String, surname: String, comp: Long, pic: String, id: Long)

    @Query("DELETE FROM staff_info where id = :id") suspend fun deleteById(id: Long)

    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insert(staff: StaffInfo): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insert(vararg staff: StaffInfo)
}