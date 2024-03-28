package edu.wccnet.mmorgan8.carddemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // you will not hardcode this data in a real project
    // it will be in another file or in a database
//    private val titles = arrayOf("Chapter One",
//        "Chapter Two", "Chapter Three", "Chapter Four",
//        "Chapter Five", "Chapter Six", "Chapter Seven",
//        "Chapter Eight")
//
//    private val details = arrayOf("Item one details", "Item two details",
//        "Item three details", "Item four details",
//        "Item five details", "Item six details",
//        "Item seven details", "Item eight details")
//
//    private val images = intArrayOf(R.drawable.android_image_1,
//        R.drawable.android_image_2, R.drawable.android_image_3,
//        R.drawable.android_image_4, R.drawable.android_image_5,
//        R.drawable.android_image_6, R.drawable.android_image_7,
//        R.drawable.android_image_8)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = DataManager.titles[i]
        viewHolder.itemDetail.text = DataManager.details[i]
        viewHolder.itemImage.setImageResource(DataManager.images[i])
    }

    override fun getItemCount(): Int {
        return DataManager.titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View  ->
                val position: Int = adapterPosition

                val intent = Intent(v.context, SecondActivity::class.java)
                intent.putExtra("position", position)
                v.context.startActivity(intent)



//                Snackbar.make(v, "Click detected on item $position",
//                    Snackbar.LENGTH_LONG).setAction("Action", null).show()

            }
        }
    }



}