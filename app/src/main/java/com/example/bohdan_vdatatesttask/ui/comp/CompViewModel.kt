package com.example.bohdan_vdatatesttask.ui.comp

import android.app.Application
import android.view.View
import android.widget.Button
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.bohdan_vdatatesttask.MainDB
import com.example.bohdan_vdatatesttask.R
import kotlinx.android.synthetic.main.fragment_comp.*
import java.lang.Exception

//for coroutines and db

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
}