package com.example.bohdan_vdatatesttask.ui.comp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "comp_info")
data class CompanyInfo (
    @PrimaryKey (autoGenerate = true) var id: Int,
    @ColumnInfo (name = "comp_name") var compName: String
)