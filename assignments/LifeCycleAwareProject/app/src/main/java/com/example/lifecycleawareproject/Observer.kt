package com.example.lifecycleawareproject

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Observer(private val viewModel: MainViewModel) : DefaultLifecycleObserver {

    private fun getTime(): String {
        val currentTime = System.currentTimeMillis()
        return SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Date(currentTime))

    }

    override fun onCreate(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onCreate was fired at: " + getTime())
    }

    override fun onStart(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onStart was fired at: " + getTime())
    }

    override fun onResume(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onResume was fired at: " + getTime())
    }

    override fun onPause(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onPause was fired at: " + getTime())
    }

    override fun onStop(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onStop was fired at: " + getTime())
    }

    override fun onDestroy(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onDestroy was fired at: " + getTime())
    }


}