package com.example.lifecycleawareproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleawareproject.databinding.ActivityMainBinding
import com.example.lifecycleawareproject.BR.myViewModel
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.lifecycleOwner = this
        binding.setVariable(myViewModel, viewModel)

        binding.lifecycleOwner = this
        binding.myViewModel = viewModel

        val lifecycleObserver = Observer(viewModel)
        lifecycle.addObserver(lifecycleObserver)


        setContentView(binding.root)
    }



}