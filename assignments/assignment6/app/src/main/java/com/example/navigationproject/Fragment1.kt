package com.example.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.databinding.Fragment1Binding
import androidx.navigation.Navigation

class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener {
            val action: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
            action.textBox = "Image 1"
            action.imageNumber = R.drawable.android_image_1.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
            action.textBox = "Image 2"
            action.imageNumber = R.drawable.android_image_2.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
            action.textBox = "Image 3"
            action.imageNumber = R.drawable.android_image_3.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

//            val actionText: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
//            actionText.textBox = "Image 1"
//            val actionImage: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
//            actionImage.imageNumber = R.drawable.android_image_1
//            Navigation.findNavController(it).navigate(actionText)
//            Navigation.findNavController(it).navigate(actionImage)