package com.example.lifecycleawareproject

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Observer(private val viewModel: MainViewModel) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        viewModel.addLifecycleEvent("onDestroy")
    }


}