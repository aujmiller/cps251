package edu.wccnet.mmorgan8.carddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.wccnet.mmorgan8.carddemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setContentView(R.layout.activity_second)

        val position = intent.getIntExtra("position", -1)
        if (position != -1) {
            val itemImage = DataManager.images[position]
            val itemTitle = DataManager.titles[position]
            val itemDetails = DataManager.details[position]

            binding.imageView.setImageResource(itemImage)
            binding.titleTextView.text = itemTitle
            binding.descTextView.text = itemDetails
        }

    }


}