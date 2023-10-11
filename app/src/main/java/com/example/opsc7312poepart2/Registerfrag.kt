package com.example.opsc7312poepart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Registerfrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment_registerfrag = inflater.inflate(R.layout.fragment_registerfrag, container, false)
        //Adjusting/Declaring buttons and values
        val btnregister: Button = fragment_registerfrag.findViewById(R.id.btnregister)
        val txtregisterusername: TextView = fragment_registerfrag.findViewById(R.id.txthotspotnearest)
        val txtregisterpassword: TextView = fragment_registerfrag.findViewById(R.id.txthotspotnearestdist)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registerfrag, container, false)
    }
}