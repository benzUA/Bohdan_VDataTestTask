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
import com.example.bohdan_vdatatesttask.MainDB
import com.example.bohdan_vdatatesttask.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class CompDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val v: View = LayoutInflater.from(context).inflate(R.layout.dialog_comp, null, false)

            builder.setView(v)
                .setPositiveButton("Сохранить"){ _, _ ->
                    GlobalScope.launch(Dispatchers.IO){
                        val compName = v.findViewById<EditText>(R.id.comp_name)
                        saveComp(compName.text.toString())
                    }
                }
                .setNegativeButton("Отмена") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private suspend fun saveComp(name: String){
        if(name.isNotEmpty())
        {
            val compDao = MainDB.getDatabase(requireContext()).companyDao()
            compDao.insert(CompanyInfo(compName = name))
        }
        else return
    }
}