package com.example.bohdan_vdatatesttask.ui.staff

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.bohdan_vdatatesttask.MainDB
import com.example.bohdan_vdatatesttask.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StaffDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val v: View = LayoutInflater.from(context).inflate(R.layout.dialog_staff, null, false)

            builder.setView(v)
                .setPositiveButton("Сохранить"){ _, _ ->
                        GlobalScope.launch(Dispatchers.IO){
                            var name: String = v.findViewById<EditText>(R.id.staff_name).text.toString()
                            var surname: String = v.findViewById<EditText>(R.id.staff_surname).text.toString()
                            var comp: Long = v.findViewById<EditText>(R.id.staff_comp).text.toString().toLong()
                            if(checkCompany(comp)) {
                                saveStaff(name, surname, comp, "_")
                                v.findViewById<TextView>(R.id.staff_alert).setTextColor(Color.parseColor("#FFFFFF"))
                                // компания существует - убирает текст
                            }
                            else {
                                v.findViewById<TextView>(R.id.staff_alert).setTextColor(Color.parseColor("#FF0000"))
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
                    val staffDao = MainDB.getDatabase(requireContext()).staffDao()
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

    private suspend fun checkCompany(i: Long): Boolean
    {
        return (MainDB.getDatabase(requireContext()).companyDao().getCompById(i) != null)
    }
}