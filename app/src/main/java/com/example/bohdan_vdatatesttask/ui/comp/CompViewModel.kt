package com.example.bohdan_vdatatesttask.ui.comp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.bohdan_vdatatesttask.MainDB


class CompViewModel(application: Application): AndroidViewModel(application) {

    private val compDao = MainDB.getDatabase(application).companyDao()
    val compList: LiveData<List<CompanyInfo>>

    init{
        compList = compDao.allComp
    }

    suspend fun insert(vararg comp:CompanyInfo)
    {
        compDao.insert(*comp)
    }

    suspend fun delete(string: String)
    {
        compDao.delete(string)
    }

    suspend fun deleteAll()
    {
        compDao.deleteAll()
    }
}