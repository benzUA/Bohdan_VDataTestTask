package com.example.bohdan_vdatatesttask.ui.comp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bohdan_vdatatesttask.MainActivity
import com.example.bohdan_vdatatesttask.R


class CompFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity?)!!.fr = R.id.navigation_comp
        return inflater.inflate(R.layout.fragment_comp, container, false)
    }
}