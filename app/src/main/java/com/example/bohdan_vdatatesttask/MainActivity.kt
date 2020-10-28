package com.example.bohdan_vdatatesttask

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
import com.example.bohdan_vdatatesttask.ui.comp.CompDialog
import com.example.bohdan_vdatatesttask.ui.comp.CompFragment
import com.example.bohdan_vdatatesttask.ui.staff.StaffDialog
import com.example.bohdan_vdatatesttask.ui.staff.StaffFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var fr = R.id.navigation_staff // active fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}