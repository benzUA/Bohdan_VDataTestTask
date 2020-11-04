package com.example.bohdan_vdatatesttask

import com.example.bohdan_vdatatesttask.ui.comp.CompanyDao
import com.example.bohdan_vdatatesttask.ui.comp.CompanyInfo
import com.example.bohdan_vdatatesttask.ui.staff.StaffDao
import com.example.bohdan_vdatatesttask.ui.staff.StaffInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

suspend fun rePopulateDb(database: MainDB?) {
    database?.let { db ->
        withContext(Dispatchers.IO) {
            val staffDao: StaffDao = db.staffDao()
            val compDao: CompanyDao = db.companyDao()

            staffDao.deleteAll()
            compDao.deleteAll()

            val companyOne = CompanyInfo(compName = "Company 1")
            val companyTwo = CompanyInfo(compName = "Company 2")

            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date()).toString()

            val staffOne = StaffInfo(staffName = "Test", staffSurname = "1", staffComp = compDao.insert(companyOne), staffPic = "1", staffDate = currentDate)
            val compId = compDao.insert(companyTwo)
            val staffTwo = StaffInfo(staffName = "Test", staffSurname = "2", staffComp = compId, staffPic = "2", staffDate = currentDate)
            val staffThree = StaffInfo(staffName = "Test", staffSurname = "3", staffComp = compId, staffPic = "3", staffDate = currentDate)

            staffDao.insert(staffOne, staffTwo, staffThree)
        }
    }
}