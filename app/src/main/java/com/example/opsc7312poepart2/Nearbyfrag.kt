package com.example.opsc7312poepart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.maps.MapView

class Nearbyfrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment_nearbyfrag = inflater.inflate(R.layout.fragment_nearbyfrag, container, false)
        //Adjusting/Declaring buttons and values
        val btnnearbyenter: Button = fragment_nearbyfrag.findViewById(R.id.btnnearbyenter)
        val txtnearbylocation: TextView = fragment_nearbyfrag.findViewById(R.id.txtnearbylocation)
        val txtnearbymaxdist: TextView = fragment_nearbyfrag.findViewById(R.id.txtnearbymaxdist)
        val txthotspotnearest: TextView = fragment_nearbyfrag.findViewById(R.id.txthotspotnearest)
        val txthotspotnearestdist: TextView = fragment_nearbyfrag.findViewById(R.id.txthotspotnearestdist)//nearbymapView
        val nearbymapView: MapView = fragment_nearbyfrag.findViewById(R.id.nearbymapView)
        return inflater.inflate(R.layout.fragment_nearbyfrag, container, false)
    }
}