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
var array=Array<String>(4,{i->""})
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)   //Layout Inflation
        dataSet=DataJujutsu().data().shuffled()    //stack of data
        var tempju:Jujutsu

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
            updateViews()var array=Array<String>(4,{i->""})
            binding.groupRadio.clearCheck()          //clear the checked option

        }
    }

    fun updateViews(){ //called once to update the first scene
        binding.image.setImageResource(jujutsu.pic1)
        binding.image2.setImageResource(jujutsu.pic2)
        val array=getOptions(count)
        array.shuffle()
        binding.option1.setText(array[0])
        binding.option2.setText(array[1])
        binding.option3.setText(array[2])
        binding.option4.setText(array[3])

    }
    fun transferActivity(){
        val intent=Intent(this,End::class.java)
        intent.putExtra("CORRECT",correct)
        intent.putExtra("INCORRECT",wrong)
        startActivity(intent)
        finish()

    }

    fun getOptions(index:Int):Array<String>{
        var pointer=dataSet[index]
        array[0]=pointer.option1
        array[1]=pointer.option2
        array[2]=pointer.option3
        array[3]=pointer.option4
        return array
    }
    }



