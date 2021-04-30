package com.example.animetrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import com.example.animetrivia.databinding.ActivityMainBinding

var count=0
var c=0
lateinit var binding:ActivityMainBinding  //Binding Variable
lateinit var dataSet:List<Jujutsu>
lateinit var jujutsu:Jujutsu
var correct=0
var wrong=0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)   //Layout Inflation
        dataSet=DataJujutsu().data()    //stack of data

            jujutsu=dataSet[count]        //Pointing to the first Scene
            updateViews()      //Updating all the view to the first Scene

            binding.button.setOnClickListener {
                analyseData(binding.groupRadio.checkedRadioButtonId)
            }

    }
    fun analyseData(id:Int) {   //analyses the score of an instance
        val checkedRadio = findViewById<RadioButton>(id)     //What is checked?
        val txt = checkedRadio.text   //It's text
        if (txt == dataSet[count].option1) {          //If it matches with the text of the current scene
            correct++  //We know What's correct
        } else
            wrong++ //We know what's Wrong
        if (count ==dataSet.size - 1) {
            count = 0
            transferActivity()
        } else {
            count++
            jujutsu=dataSet[count]
            updateViews()
            binding.groupRadio.clearCheck()          //clear the checked option

        }
    }

    fun updateViews(){ //called once to update the first scene
        binding.image.setImageResource(jujutsu.pic1)
        binding.image2.setImageResource(jujutsu.pic2)
        binding.option1.setText(jujutsu.option1)
        binding.option2.setText(jujutsu.option2)
        binding.option3.setText(jujutsu.option3)
        binding.option4.setText(jujutsu.option4)

    }
    fun transferActivity(){
        val intent=Intent(this,End::class.java)
        intent.putExtra("CORRECT",correct)
        intent.putExtra("INCORRECT",wrong)
        startActivity(intent)
        finish()

    }
    }



