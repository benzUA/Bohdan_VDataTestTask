package com.example.bohdan_vdatatesttask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.bohdan_vdatatesttask.ui.comp.CompanyDao
import com.example.bohdan_vdatatesttask.ui.comp.CompanyInfo
import com.example.bohdan_vdatatesttask.ui.staff.StaffDao
import com.example.bohdan_vdatatesttask.ui.staff.StaffInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [CompanyInfo::class, StaffInfo::class], version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun companyDao(): CompanyDao
    abstract fun staffDao(): StaffDao

    companion object {
        private var INSTANCE: MainDB? = null
        private const val DB_NAME = "main.db"

        fun getDatabase(context: Context): MainDB {
            if (INSTANCE == null) {
                synchronized(MainDB::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext, MainDB::class.java, DB_NAME)
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    GlobalScope.launch(Dispatchers.IO) { rePopulateDb(INSTANCE) }
                                }
                            }).build()
                    }
                }
            }

            return INSTANCE!!
        }
    }
}