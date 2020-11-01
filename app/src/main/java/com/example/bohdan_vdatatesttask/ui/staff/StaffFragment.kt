package com.example.bohdan_vdatatesttask.ui.staff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bohdan_vdatatesttask.MainActivity
import com.example.bohdan_vdatatesttask.R

import java.lang.Exception

class StaffFragment : Fragment() {

    private lateinit var staffViewModel: StaffViewModel
    private lateinit var staffList: List<StaffInfo>
    private lateinit var v: View
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity?)!!.fr = R.id.navigation_staff
        val view = inflater.inflate(R.layout.fragment_staff, container, false)
        v = view
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        staffViewModel = ViewModelProvider(this).get(StaffViewModel::class.java)
        staffViewModel.staffList.observe(this, Observer {
                staff: List<StaffInfo> ->
            staffList = staff
            showStaff()
        })
    }

    private fun showStaff(){
        try{v.findViewById<Button>(R.id.staff1).text = (staffList[0].id.toString()+") "+staffList[0].staffName+" "+staffList[0].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff1).text = "-"}

        try{v.findViewById<Button>(R.id.staff2).text = (staffList[1].id.toString()+") "+staffList[1].staffName+" "+staffList[1].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff2).text = "-"}

        try{v.findViewById<Button>(R.id.staff3).text = (staffList[2].id.toString()+") "+staffList[2].staffName+" "+staffList[2].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff3).text = "-"}

        try{v.findViewById<Button>(R.id.staff4).text = (staffList[3].id.toString()+") "+staffList[3].staffName+" "+staffList[3].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff4).text = "-"}

        try{v.findViewById<Button>(R.id.staff5).text = (staffList[4].id.toString()+") "+staffList[4].staffName+" "+staffList[4].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff5).text = "-"}

        try{v.findViewById<Button>(R.id.staff6).text = (staffList[5].id.toString()+") "+staffList[5].staffName+" "+staffList[5].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff6).text = "-"}

        try{v.findViewById<Button>(R.id.staff7).text = (staffList[6].id.toString()+") "+staffList[6].staffName+" "+staffList[6].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff7).text = "-"}

        try{v.findViewById<Button>(R.id.staff8).text = (staffList[7].id.toString()+") "+staffList[7].staffName+" "+staffList[7].staffSurname)}
        catch(e: Exception) {v.findViewById<Button>(R.id.staff8).text = "-"}
        //если обращаемся к несуществующим элементам
    }
}