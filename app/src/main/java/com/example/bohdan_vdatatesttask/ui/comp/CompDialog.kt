package com.example.bohdan_vdatatesttask.ui.comp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.bohdan_vdatatesttask.R

class CompDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setView(LayoutInflater.from(context).inflate(R.layout.dialog_comp, null, false))
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