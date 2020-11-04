package com.example.bohdan_vdatatesttask.ui.comp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bohdan_vdatatesttask.MainDB
import com.example.bohdan_vdatatesttask.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CompShowDetails: AppCompatActivity() {

    private lateinit var compName: String
    private var compId: Long? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.company_details)

        val intent: Intent = intent
        compName = intent.getStringExtra("comp_name").toString()
        compId = intent.getStringExtra("comp_id")?.toLong()
        val viewInsert = findViewById<TextView>(R.id.comp_name_view).text.toString() + compName
        findViewById<TextView>(R.id.comp_name_view).text = viewInsert

        val staffAmountView = findViewById<TextView>(R.id.comp_staff_amount)
        val context = this

        var staffHistory = findViewById<TextView>(R.id.comp_staff_history).text.toString()

        GlobalScope.launch(Dispatchers.IO){
            val staffDao = MainDB.getDatabase(context).staffDao()
            compId?.let { val amount = staffAmountView.text.toString() + staffDao.getStaffByComp(it).toString()
                val staffDates = staffDao.getStaffDateByComp(it)
                staffAmountView.text = amount

                for(i in staffDates.indices){
                    staffHistory = staffHistory + staffDates[i].staff_date + ": " +
                            staffDates[i].staff_name + " " + staffDates[i].staff_surname + "\n"
                }

                findViewById<TextView>(R.id.comp_staff_history).text = staffHistory
            }
        }
    }
}