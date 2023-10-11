package com.example.opsc7312poepart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

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
    }
}