package com.example.tipcalculatorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculatorproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calcTip(view : View) {

        if (binding.editTextNumberDecimal.text.isNotEmpty()) {
            val billTotal = binding.editTextNumberDecimal.text.toString().toFloat()
            val tenPercent = String.format("%.2f", billTotal * .1 + billTotal)
            val fifteenPercent = String.format("%.2f", billTotal * .15 + billTotal)
            val twentyPercent = String.format("%.2f", billTotal * .2 + billTotal)
            val tipOutput = ("The tips are as follows: \n\n 10% = \t $tenPercent \n 15% = \t $fifteenPercent \n 20% = \t $twentyPercent")
            binding.textView.text = tipOutput

        } else {
            binding.textView.text = getString(R.string.error)
        }

    }

}