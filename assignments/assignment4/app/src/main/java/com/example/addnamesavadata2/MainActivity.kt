package com.example.addnamesavadata2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.addnamesavadata2.databinding.ActivityMainBinding
import com.example.addnamesavadata2.BR.myViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.lifecycleOwner = this
        binding.setVariable(myViewModel, viewModel)

        // binding = ActivityMainBinding.inflate(layoutInflater)



        // binding.textView.text = viewModel.getName()

//        binding.button.setOnClickListener{
//            if (binding.editText.text.isNotEmpty()) {
//                viewModel.addName(binding.editText.text.toString())
//                binding.textView.text = viewModel.getName()
//            } else {
//                binding.textView.text = getString(R.string.errorMessage)
//            }
//        }
        setContentView(binding.root)


    }



}