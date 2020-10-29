package com.example.bohdan_vdatatesttask.ui.staff

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.bohdan_vdatatesttask.MainActivity
import com.example.bohdan_vdatatesttask.R
import kotlinx.android.synthetic.main.dialog_staff.*

class StaffDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val v: View = LayoutInflater.from(context).inflate(R.layout.dialog_staff, null, false)

            builder.setView(v)
                .setPositiveButton("Сохранить"){ dialog, _ ->
                    run {
                        var name: String = v.findViewById<EditText>(R.id.staff_name).text.toString()
                        var surname: String = v.findViewById<EditText>(R.id.staff_surname).text.toString()
                        var comp: String = v.findViewById<EditText>(R.id.staff_comp).text.toString()
                        var pic: String = v.findViewById<EditText>(R.id.staff_pic).text.toString()
                        if (name.isNotEmpty() && surname.isNotEmpty() && comp.isNotEmpty() && pic.isNotEmpty()) {
                            (activity as MainActivity?)!!.insertStaffTable(name, surname, comp, pic)
                            dialog.cancel()
                            Log.d("a", "DialogDB")
                        }
                    }
                }
                .setNegativeButton("Отмена") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}