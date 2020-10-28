package com.example.bohdan_vdatatesttask.ui.staff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bohdan_vdatatesttask.MainActivity
import com.example.bohdan_vdatatesttask.R

class StaffFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity?)!!.fr = R.id.navigation_staff
        return inflater.inflate(R.layout.fragment_staff, container, false)
    }
}