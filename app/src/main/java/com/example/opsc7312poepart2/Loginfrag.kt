package com.example.opsc7312poepart2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Loginfrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment_loginfrag = inflater.inflate(R.layout.fragment_loginfrag, container, false)
        //Adjusting/Declaring buttons and values
        val btnlogin: Button = fragment_loginfrag.findViewById(R.id.btnlogin)
        val btnregisterpage: Button = fragment_loginfrag.findViewById(R.id.btnregisterpage)
        val txtloginusername: TextView = fragment_loginfrag.findViewById(R.id.txtloginusername)
        val txtloginpassword: TextView = fragment_loginfrag.findViewById(R.id.txtloginpassword)
        //
        return inflater.inflate(R.layout.fragment_loginfrag, container, false)
        //return the variables
        //val fragment_loginfrag = inflater.inflate(R.layout.fragment_loginfrag, container, false)

        //Logs User into system
        btnlogin.setOnClickListener(){
            //txtcurrenthunger.text = feed++.toString()
        }
        //redirects to register Page
        btnregisterpage.setOnClickListener(){
            val i = Intent(applicationContext, Main2Activity::class.java)
            startActivity(i)
        }
    }
}