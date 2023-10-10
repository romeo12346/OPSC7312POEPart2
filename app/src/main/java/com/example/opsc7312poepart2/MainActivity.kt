package com.example.opsc7312poepart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Adjusting buttons and values
        val btnhotspots = findViewById(R.id.btnhotspots)
        val btnnearby = findViewById(R.id.btnnearby)
        val btnbirds = findViewById(R.id.btnbirds)
        val btnrare = findViewById(R.id.btnrare)
        val btnchecklists = findViewById(R.id.btnchecklists)
        val btnsettings = findViewById(R.id.btnsettings)
    }
}