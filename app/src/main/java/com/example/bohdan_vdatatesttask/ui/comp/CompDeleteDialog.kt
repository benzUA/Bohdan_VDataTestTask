package com.example.bohdan_vdatatesttask.ui.comp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.bohdan_vdatatesttask.MainDB
import com.example.bohdan_vdatatesttask.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CompDeleteDialog(str: String): DialogFragment() {
    var name: String = str

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Удалить компанию?")
                .setPositiveButton("Да") { _, _ ->
                GlobalScope.launch(Dispatchers.IO){
                    deleteComp(name)
                }
            }
                .setNegativeButton("Отмена"){
                    dialog, _ -> dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private suspend fun deleteComp(name: String){
        val compDao = MainDB.getDatabase(requireContext()).companyDao()
        compDao.delete(name)
    }
}