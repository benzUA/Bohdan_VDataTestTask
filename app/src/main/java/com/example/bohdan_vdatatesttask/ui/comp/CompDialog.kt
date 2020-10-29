package com.example.bohdan_vdatatesttask.ui.comp

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
import kotlinx.android.synthetic.main.dialog_comp.*


class CompDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val v: View = LayoutInflater.from(context).inflate(R.layout.dialog_comp, null, false)

            builder.setView(v)
                .setPositiveButton("Сохранить"){ dialog, _ ->
                        val text: String = v.findViewById<EditText>(R.id.comp_name).text.toString()
               //       val et = dialog.getDialog().findViewById(R.id.comp_name)
                        if (text.isNotEmpty()) {
                            (activity as MainActivity?)!!.insertCompTable(text)
                            dialog.cancel()
                            Log.d("a", "DialogDB")
                    }
                }
                .setNegativeButton("Отмена") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}