package com.example.bohdan_vdatatesttask.ui.staff

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.bohdan_vdatatesttask.R

class StaffDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setView(LayoutInflater.from(context).inflate(R.layout.dialog_staff, null, false))
                .setPositiveButton("Сохранить"){
                        dialog, _ ->  dialog.cancel()
                }
                .setNegativeButton("Отмена") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}