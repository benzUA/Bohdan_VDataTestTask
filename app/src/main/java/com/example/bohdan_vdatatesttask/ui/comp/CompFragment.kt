package com.example.bohdan_vdatatesttask.ui.comp

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


class CompFragment : Fragment() {

    private lateinit var compViewModel: CompViewModel
    private lateinit var compList: List<CompanyInfo>
    private lateinit var v: View

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity?)!!.fr = R.id.navigation_comp
        val view = inflater.inflate(R.layout.fragment_comp, container, false)
        v = view
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compViewModel = ViewModelProvider(this).get(CompViewModel::class.java)
        compViewModel.compList.observe(this, Observer {
            companies: List<CompanyInfo> ->
            compList = companies
            showCompanies()
            setLongClickListeners()
        })
    }


    private fun showCompanies(){

        try{v.findViewById<Button>(R.id.comp1).text = (compList[0].id.toString()+") "+compList[0].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp1).text = "-"}

        try{v.findViewById<Button>(R.id.comp2).text = (compList[1].id.toString()+") "+compList[1].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp2).text = "-"}

        try{v.findViewById<Button>(R.id.comp3).text = (compList[2].id.toString()+") "+compList[2].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp3).text = "-"}

        try{v.findViewById<Button>(R.id.comp4).text = (compList[3].id.toString()+") "+compList[3].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp4).text = "-"}

        try{v.findViewById<Button>(R.id.comp5).text = (compList[4].id.toString()+") "+compList[4].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp5).text = "-"}

        try{v.findViewById<Button>(R.id.comp6).text = (compList[5].id.toString()+") "+compList[5].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp6).text = "-"}

        try{v.findViewById<Button>(R.id.comp7).text = (compList[6].id.toString()+") "+compList[6].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp7).text = "-"}

        try{v.findViewById<Button>(R.id.comp8).text = (compList[7].id.toString()+") "+compList[7].compName)}
        catch(e: Exception) {v.findViewById<Button>(R.id.comp8).text = "-"}
        //если обращаемся к несуществующим элементам
    }

   private fun setLongClickListeners()
    {
        lateinit var str: String
        v.findViewById<Button>(R.id.comp1).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp1).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
        v.findViewById<Button>(R.id.comp2).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp2).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
        v.findViewById<Button>(R.id.comp3).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp3).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
        v.findViewById<Button>(R.id.comp4).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp4).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
        v.findViewById<Button>(R.id.comp5).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp5).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
        v.findViewById<Button>(R.id.comp6).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp6).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
        v.findViewById<Button>(R.id.comp7).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp7).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
        v.findViewById<Button>(R.id.comp8).setOnLongClickListener {
            str = v.findViewById<Button>(R.id.comp8).text.toString()
            if(str != "-")
            {
                str = str.substring(3, str.length)  //убрать ид
                val dialog = CompDeleteDialog(str)
                dialog.show(requireFragmentManager(), "")
            }
            true
        }
    }
}