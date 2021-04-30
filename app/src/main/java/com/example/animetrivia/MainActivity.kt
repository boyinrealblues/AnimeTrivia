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

var count=1
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

        val EXTRA_CORRECT="com.example.MainActivity.CORRECT"
        val EXTRA_WRONG="com.example.MainActivity.WRONG"

        val objData=DataJujutsu()  //DataJujutsu object
        dataSet=objData.data()    //stack of data

            jujutsu=dataSet[0]        //Pointing to the first Scene
            firstRedundantCall()      //Updating all the view to the first Scene

            binding.button.setOnClickListener {
                analyse(binding.groupRadio.checkedRadioButtonId)
                jujutsu=dataSet[count++]
            binding.image.setImageResource(jujutsu.pic1)
            binding.image2.setImageResource(jujutsu.pic2)
            binding.option1.setText(jujutsu.option1)
            binding.option2.setText(jujutsu.option2)
            binding.option3.setText(jujutsu.option3)
            binding.option4.setText(jujutsu.option4)
                Log.e("${correct} ${wrong} ${dataSet[c].option1}","check")
                binding.groupRadio.clearCheck()          //clear the checked option
            }
        if(count>dataSet.size-3){
            val intent=Intent(this,End::class.java)
                 intent.putExtra("CORRECT",correct)
                 intent.putExtra("INCORRECT",wrong)
              startActivity(intent)
        }
    }
    fun analyse(id:Int){   //analyses the score of an instance
               val checkedRadio=findViewById<RadioButton>(id)     //What is checked?
        val txt=checkedRadio.text   //Its text
        if(txt==dataSet[c].option1){          //If it matches with the text of the current scene
          correct++  //We know What's correct
        }else
            wrong++ //We know what's Wrong
        c++
    }

    fun firstRedundantCall(){ //called once to update the first scene
        binding.image.setImageResource(jujutsu.pic1)
        binding.image2.setImageResource(jujutsu.pic2)
        binding.option1.setText(jujutsu.option1)
        binding.option2.setText(jujutsu.option2)
        binding.option3.setText(jujutsu.option3)
        binding.option4.setText(jujutsu.option4)

    }
    }



