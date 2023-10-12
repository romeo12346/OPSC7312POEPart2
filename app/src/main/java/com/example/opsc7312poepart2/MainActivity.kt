package com.example.opsc7312poepart2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Adjusting/Declaring buttons and values
        val btnhotspots: Button = findViewById(R.id.btnhotspots)
        val btnnearby: Button = findViewById(R.id.btnnearby)
        val btnbirds: Button = findViewById(R.id.btnbirds)
        val btnrare: Button = findViewById(R.id.btnrare)
        val btnchecklists: Button = findViewById(R.id.btnchecklists)
        val btnsettings: Button = findViewById(R.id.btnsettings)

        //Button Methods
//        btnhotspots.setOnClickListener(){
//            val i = Intent(this, fragment_hotspotsfrag::class.java)//Must create .xml
//            startActivity(i)
//        }
        btnnearby.setOnClickListener(){
            val i = Intent(this, Nearbyfrag::class.java)
            startActivity(i)
        }
        btnbirds.setOnClickListener(){
            val i = Intent(this, Birdsfrag::class.java)//Must create .xml
            startActivity(i)
        }
//        btnrare.setOnClickListener(){
//            val i = Intent(this, fragment_rarefrag::class.java)//Must create .xml
//            startActivity(i)
//        }
        btnchecklists.setOnClickListener(){
            val i = Intent(this, Checklistsfrag::class.java)//Must create .xml
            startActivity(i)
        }
        btnsettings.setOnClickListener(){
            val i = Intent(this, Settingsfrag::class.java)
            startActivity(i)
        }
    }
}