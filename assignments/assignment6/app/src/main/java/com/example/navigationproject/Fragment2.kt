package com.example.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.databinding.Fragment2Binding
import android.net.Uri

class Fragment2 : Fragment() {

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val argsText = Fragment2Args.fromBundle(it)
            binding.textView.text = argsText.textBox
            val argsImage = argsText.imageNumber.toIntOrNull() ?: 0
            binding.imageView4.setImageResource(argsImage)
        }
    }

}