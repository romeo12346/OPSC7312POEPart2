package com.example.opsc7312poepart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Createchecklistsfrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val createchecklistsfrag = inflater.inflate(R.layout.fragment_createchecklistsfrag, container, false)
        // Inflate the layout for this fragment
        return createchecklistsfrag
    }

}