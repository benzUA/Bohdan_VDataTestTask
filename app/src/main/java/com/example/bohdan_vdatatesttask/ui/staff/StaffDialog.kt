package com.example.bohdan_vdatatesttask.ui.staff

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.bohdan_vdatatesttask.MainDB
import com.example.bohdan_vdatatesttask.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StaffDialog: DialogFragment() {
    var picSelected: String = "-1"
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val v: View = LayoutInflater.from(context).inflate(R.layout.dialog_staff, null, false)

            var image = v.findViewById<Button>(R.id.staff_pic)
            image.setOnClickListener{
                val intent = Intent(context, StaffImagesView::class.java)
                startActivityForResult(intent, 0)
            }

            builder.setView(v)
                .setPositiveButton("Сохранить"){ _, _ ->
                        GlobalScope.launch(Dispatchers.IO){
                            var name: String = v.findViewById<EditText>(R.id.staff_name).text.toString()
                            var surname: String = v.findViewById<EditText>(R.id.staff_surname).text.toString()
                            var comp: Long = v.findViewById<EditText>(R.id.staff_comp).text.toString().toLong()
                            if(checkCompany(comp)) {
                                if(picSelected != "-1") {
                                    saveStaff(name, surname, comp, picSelected)
                                    val alert = v.findViewById<TextView>(R.id.staff_alert)
                                    alert.setTextColor(Color.parseColor("#FFFFFF"))
                                    // компания существует - убирает текст
                                }
                                else{
                                    val alert = v.findViewById<TextView>(R.id.staff_alert)
                                    alert.setTextColor(Color.parseColor("#FF0000"))
                                }
                            }
                            else {
                                val alert = v.findViewById<TextView>(R.id.staff_alert)
                                alert.setTextColor(Color.parseColor("#FF0000"))
                                //если компании не существует то красит в красный текст
                            }
                        }
                }
                .setNegativeButton("Отмена") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private suspend fun saveStaff(name: String, surname: String, comp: Long, pic: String){
            if (name.isNotEmpty() && surname.isNotEmpty()) {
                val staffDao = context?.let { MainDB.getDatabase(it).staffDao() }
                if (staffDao != null) {
                    staffDao.insert(
                        StaffInfo(
                            staffName = name,
                            staffSurname = surname,
                            staffPic = pic,
                            staffComp = comp
                        )
                    )
                }
            }
    }

    private suspend fun checkCompany(i: Long): Boolean
    {
        val compDao = MainDB.getDatabase(requireContext()).companyDao()
        return try{
            compDao.getCompById(i).compName
            true
        } catch(e: Exception){
            false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val mesReturned = data?.getStringExtra("message_return")
        if (mesReturned != null) {
            picSelected = mesReturned
        }
    }
}