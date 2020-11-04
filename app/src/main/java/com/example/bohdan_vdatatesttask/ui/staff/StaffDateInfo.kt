package com.example.bohdan_vdatatesttask.ui.staff

import androidx.room.ColumnInfo

data class StaffDateInfo (
    @ColumnInfo(name = "staff_name") var staff_name: String,
    @ColumnInfo(name = "staff_surname") var staff_surname: String,
    @ColumnInfo(name = "staff_date") var staff_date: String
)
//для отдельных столбцов из бд