package com.example.bohdan_vdatatesttask.ui.staff

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.bohdan_vdatatesttask.MainDB


class StaffViewModel(application: Application): AndroidViewModel(application) {

    private val staffDao = MainDB.getDatabase(application).staffDao()
    val staffList: LiveData<List<StaffInfo>>

    init{
        staffList = staffDao.allStaff
    }

    suspend fun insert(vararg staff:StaffInfo)
    {
        staffDao.insert(*staff)
    }

    suspend fun deleteAll()
    {
        staffDao.deleteAll()
    }
}