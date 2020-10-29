package com.example.bohdan_vdatatesttask.ui.comp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CompanyInfo::class], version = 1)
abstract class CompanyDB : RoomDatabase() {
    abstract fun companyDao(): CompanyDao
}