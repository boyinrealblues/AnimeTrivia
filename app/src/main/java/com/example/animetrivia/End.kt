package com.example.animetrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class End : AppCompatActivity() {
    var correct=0
    var wrong=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val intent: Intent = getIntent()
        correct = intent.getIntExtra("CORRECT", 0)   //Retrieve data
        wrong = intent.getIntExtra("INCORRECT", 0)   //Retrieve data

        val textRight = findViewById<TextView>(R.id.correct_text)
        val textWrong = findViewById<TextView>(R.id.wrong_text)
        textRight.setText(correct.toString())
        textWrong.setText(wrong.toString())

        val again=findViewById<Button>(R.id.again_button)
        val end=findViewById<Button>(R.id.end_button)

        end.setOnClickListener {
            finish()
        }
        again.setOnClickListener {
            var intent2=Intent(this,Start::class.java)
            startActivity(intent2)
            finish()
        }

    }
}