package com.example.addnamesavadata1v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import  com.example.addnamesavadata1v2.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)

        // this line re-calls getResult() to output that text after rotation!
        // onCreate is called after rotation because the activity has to be rebuilt
        binding.textView.text = viewModel.getName()

        binding.button.setOnClickListener{
            if (binding.editText.text.isNotEmpty()) {
                viewModel.addName(binding.editText.text.toString())
                binding.textView.text = viewModel.getName()
            } else {
                binding.textView.text = getString(R.string.errorMessage)
            }
        }
        setContentView(binding.root)


    }



}


