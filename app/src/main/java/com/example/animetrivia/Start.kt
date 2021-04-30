package com.example.animetrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val button=findViewById<Button>(R.id.play_button)
        button.setOnClickListener {
           val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}