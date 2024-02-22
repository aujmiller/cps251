package com.example.addnamesavadata2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

//    private var name = ""

    var nameValue: MutableLiveData<String> = MutableLiveData()
    var newNameValue: MutableLiveData<String> = MutableLiveData()

    fun addNameValue(value: String) {
        //nameValue.value += "$value \n"
    }

    var name = ""

    fun testNameValue(value: String) {
        newNameValue.let {
            if (!it.value.equals("")) {

                name += value + "\n"
                nameValue.value = name
            } else {
                nameValue.value = ""
            }
        }
    }

//    fun addName(value: String) {
//        this.name += "$value \n"
//    }
//
//    fun getName(): String {
//        return name
//    }



}