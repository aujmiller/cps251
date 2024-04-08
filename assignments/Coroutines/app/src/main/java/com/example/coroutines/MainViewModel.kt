package com.example.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()  {

    companion object {
        // val list = mutableListOf<String>()
        val list: MutableList<String> = ArrayList()

    }

    fun addName(output: String) {
        list.add(output)
        Log.i("zzz", "nameList added")

    }

}