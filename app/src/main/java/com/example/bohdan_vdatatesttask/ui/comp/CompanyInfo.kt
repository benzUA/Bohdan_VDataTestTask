package com.example.bohdan_vdatatesttask.ui.comp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (tableName = "comp_info", indices = [Index(value = ["comp_name"], unique = true)])
data class CompanyInfo(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id") var id: Long = 0,
    @ColumnInfo (name = "comp_name") var compName: String
) {
    constructor(): this(0L, "")
}