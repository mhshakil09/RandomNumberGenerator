package com.example.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var temp = 0
    var rand = 0
    var lowerLimit = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var tvDisplayResult: TextView = findViewById(R.id.tvDisplayResult)
//        var seekBar: SeekBar = findViewById(R.id.seekBar)
//        var buttonGenerate: Button = findViewById(R.id.buttonGenerate)
//        var buttonSet: Button = findViewById(R.id.buttonSet)
//        var buttonReset: Button = findViewById(R.id.buttonReset)

//        var temp = 0
//        var rand = 0
//        var lowerLimit = 0
//        var upperLimit = seekBar.progress


//        buttonSet.setOnClickListener(){
//            lowerLimit =
//        }


//            --------------------------------------------------------------------------------------
        fun generated(lowerLimit:Int, upperLimit: Int ){

            while (true){
                rand = Random.nextInt(lowerLimit, upperLimit+1)
                if (upperLimit == 1){
                    rand = 1
                    break
                }
                if (temp != rand){
                    temp = rand
                    break
                }

            }

            tvDisplayResult.text = rand.toString()
//            tvDisplayResult.text = " " + rand + " " + temp
        }
//            --------------------------------------------------------------------------------------
        fun animationForIsBlank(upperLimit:Int){
                tvDisplayResult.text = "0"
                tvDisplayResult.animate().apply {
                    duration = 1500
                    rotationYBy(3600f)
                }.withEndAction{
                     val temp = generated(lowerLimit+1, upperLimit+1)
                }
        }
        fun animationForIsNotBlank(){
            tvDisplayResult.text = "0"
            tvDisplayResult.animate().apply {
                duration = 1500
                rotationYBy(3600f)
            }.withEndAction{
                var temp = generated(etFrom.text.toString().toInt(), etTo.text.toString().toInt())
            }
        }
//            --------------------------------------------------------------------------------------


        buttonReset.setOnClickListener(){
            etFrom.text.clear()
            etTo.text.clear()
            tvDisplayResult.text = "0"
        }

//            --------------------------------------------------------------------------------------

        buttonGenerate.setOnClickListener(){

            var upperLimit = seekBar.progress


            if (etFrom.text.isBlank() && etTo.text.isBlank()){
                animationForIsBlank(upperLimit)
//                val temp = generated(lowerLimit+1, upperLimit+1)
            }
            if (etFrom.text.isNotBlank() && etTo.text.isBlank()){
                etTo.setError("required")
            }
            if (etFrom.text.isBlank() && etTo.text.isNotBlank()){
                etFrom.setError("required")
            }
            if (etFrom.text.isNotBlank() && etTo.text.isNotBlank()){
                if (etFrom.text.toString().toInt() >= etTo.text.toString().toInt()){
                    etTo.error = "should be bigger than " + etFrom.text
                }
                else{
                    animationForIsNotBlank()
//                    var temp = generated(etFrom.text.toString().toInt(), etTo.text.toString().toInt())
                }
            }

        }
//        ------------------------------------------------------------------------------------------

    }

}