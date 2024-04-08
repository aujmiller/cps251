package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutines.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var viewModel: MainViewModel
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        binding.button.setOnClickListener {
            coroutineScope.launch(Dispatchers.Main) {
                addName()
            }
        }

    }

    private suspend fun addName() {
        val name = binding.editText.text.toString()

        if (name.isEmpty()) {
            Log.i("zzz","enter a name")
        }
        else {
            binding.editText.text.clear()
            binding.editText.requestFocus()
            val num = ((0..9).random() * 1000)
            delay(num.toLong())
            val output = "The name is $name and the delay was $num milliseconds"
            viewModel.addName(output)
            adapter?.notifyDataSetChanged()
        }


    }

}