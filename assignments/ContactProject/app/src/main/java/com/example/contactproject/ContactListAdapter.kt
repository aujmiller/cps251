package com.example.contactproject

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ContactListAdapter(private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    var listener: onItemClickListener? = null

    fun settingListener(listener: onItemClickListener?) {
        this.listener = listener
    }

    interface onItemClickListener {
        fun onClick(id: String)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item = holder.item
        val phone = holder.phone
        val contactId = holder.contactId
        val deleteButton = holder.deleteButton

        contactList.let {
            item.text = it!![listPosition].contactName
            phone.text = it!![listPosition].phoneNumber
            contactId.text = it!![listPosition].id.toString()

        }

        deleteButton.setOnClickListener(View.OnClickListener {
            var id = contactId.text.toString()
            listener?.onClick(id)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var item: TextView
        var phone: TextView
        var contactId: TextView
        var deleteButton: ImageView

        init {

            item = itemView.findViewById(R.id.contactName)
            phone = itemView.findViewById(R.id.contactPhone)
            contactId = itemView.findViewById(R.id.contactIdView)
            deleteButton = itemView.findViewById(R.id.deleteButton)


        }




       // var item: TextView = itemView.findViewById(R.id.contactName)
      //  var phone: TextView = itemView.findViewById(R.id.contactPhone)

        // TRASH CAN DELETE GOES HERE, LIKE THE PROJECT THAT DISPLAYED THE
        // IMAGES BY WHICH CARD WAS PICKED
    }


}