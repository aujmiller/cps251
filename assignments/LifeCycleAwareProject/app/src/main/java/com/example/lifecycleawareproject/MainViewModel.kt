package com.example.lifecycleawareproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val lifecycleEvents: MutableLiveData<String> = MutableLiveData()

    init {
        lifecycleEvents.value = ""
    }

    fun addLifecycleEvent(event: String) {
        val currentEvents = lifecycleEvents.value
        val updatedEvents = "$currentEvents\n$event"
        lifecycleEvents.value = updatedEvents + "\n*****"
    }



}


