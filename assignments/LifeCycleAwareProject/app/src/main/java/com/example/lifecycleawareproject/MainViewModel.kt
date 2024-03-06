package com.example.lifecycleawareproject

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var lifecycleEvents: MutableLiveData<String> = MutableLiveData()

    fun addLifecycleEvent(event: String) {
        val currentTime = System.currentTimeMillis()
        // lifecycleEvents.add("$event: $currentTime")


    }



}


