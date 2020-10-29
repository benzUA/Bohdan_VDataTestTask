package com.example.bohdan_vdatatesttask.ui.staff

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StaffInfo::class], version = 1)
abstract class StaffDB : RoomDatabase() {
    abstract fun staffDao(): StaffDao
}