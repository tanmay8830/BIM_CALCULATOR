package com.example.bim_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bim_calculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.calculatebtn.setOnClickListener {
            CalculateBMI()
        }
    }

   private fun CalculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        if (weight != null && height != null ){
            val bmi = weight/ (height/100).pow(2)
            val bmiResult = String.format("%.2f" , bmi)

            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal Weight"
                bmi < 30 -> "Overweight"
                else -> "Obese"
            }
            binding.resultText.text = "BMI: $bmiResult\nCategory: $bmiCategory"
        }else{
            binding.resultText.text = "Invalid Input"
        }
    }
}