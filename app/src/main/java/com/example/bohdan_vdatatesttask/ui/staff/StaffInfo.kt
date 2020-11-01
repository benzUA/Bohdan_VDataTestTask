package com.example.bohdan_vdatatesttask.ui.staff

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "staff_info")
data class StaffInfo (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id") var id: Long = 0,
    @ColumnInfo (name = "staff_name") var staffName: String,
    @ColumnInfo (name = "staff_surname") var staffSurname: String,
    @ColumnInfo (name = "staff_comp") var staffComp: Long,
    @ColumnInfo (name = "staff_pic") var staffPic: String
)