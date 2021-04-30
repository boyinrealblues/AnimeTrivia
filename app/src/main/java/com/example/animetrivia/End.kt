package com.example.animetrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil

class End : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        val intent: Intent = getIntent()
        val correct = intent.getIntExtra("CORRECT", 0)
        val wrong = intent.getIntExtra("INCORRECT", 0)
        val textRight = findViewById<TextView>(R.id.correct_text)
        val textWrong = findViewById<TextView>(R.id.wrong_text)
        textRight.setText(correct)
        textWrong.setText(wrong)
    }
}