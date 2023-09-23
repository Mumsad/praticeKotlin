package com.example.menuexc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val customMenu = com.example.menuexc.Custom()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showPopUp=findViewById<Button>(R.id.btn)

        showPopUp.setOnClickListener{
            customMenu.showMenu(this,it)
        }

    }
}