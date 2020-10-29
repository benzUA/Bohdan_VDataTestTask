package com.example.bohdan_vdatatesttask

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.bohdan_vdatatesttask.ui.comp.*
import com.example.bohdan_vdatatesttask.ui.staff.StaffDB
import com.example.bohdan_vdatatesttask.ui.staff.StaffDialog
import com.example.bohdan_vdatatesttask.ui.staff.StaffFragment
import com.example.bohdan_vdatatesttask.ui.staff.StaffInfo
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var fr = R.id.navigation_staff // active fragment

    private lateinit var dbComp: CompanyDB
    private lateinit var dbStaff: StaffDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbComp = Room.databaseBuilder(
            this,
            CompanyDB::class.java, "comp_info.db"
        ).build()

        dbStaff = Room.databaseBuilder(
            this,
            StaffDB::class.java, "staff_info.db"
        ).build()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val toolbar: Toolbar = findViewById(R.id.toolbar_all)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_comp, R.id.navigation_staff))

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(R.menu.toolbar_button, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.toolbar_button) {
            showFragment()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showFragment(){
        when(fr) {
            R.id.navigation_comp -> {
                val dialog = CompDialog()
                dialog.show(supportFragmentManager, "")
            }
            R.id.navigation_staff -> {
                val dialog = StaffDialog()
                dialog.show(supportFragmentManager, "")
            }
            else -> {
                throw IllegalStateException("Fragment cannot be null")
            }
        }
    }

    fun insertCompTable(data: String){
        AsyncThread{
            dbComp.companyDao().insert(CompanyInfo(0,data))
        }.execute()
    }

    fun deleteCompTable(data: String){
        AsyncThread{
            dbComp.companyDao().delete(data)
        }.execute()
    }

    fun insertStaffTable(name: String, surname: String, comp: String, pic: String){
        AsyncThread{
            dbStaff.staffDao().insert(StaffInfo(0, name, surname, comp, pic))
        }.execute()
    }
}