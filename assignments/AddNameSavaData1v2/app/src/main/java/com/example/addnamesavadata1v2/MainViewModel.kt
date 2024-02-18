package com.example.addnamesavadata1v2

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var name = ""

    fun addName(value: String) {
        this.name += "$value \n"
    }

    fun getName(): String {
        return name
    }



}