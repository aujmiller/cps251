package com.example.contactproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.enterText.setText("")
        binding.enterPhone.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.enterText.text.toString()
            val phoneNumber = binding.enterPhone.text.toString()
            if (name != "" && phoneNumber != "") {
                val contact = Contact(name, phoneNumber)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                val text = "There was a problem adding the new contact."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, text, duration)
                toast.show()
            }
        }

        binding.findButton.setOnClickListener {
            val search = binding.enterText.text.toString()
            if (search != "") {
                viewModel.findContact(search)
            } else {
                val text = "There was a problem finding contacts."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, text, duration)
                toast.show()
            }
        }

        binding.ascButton.setOnClickListener {
            viewModel.sortAsc()
        }

        binding.descButton.setOnClickListener {
            viewModel.sortDesc()
        }

        // DO I BIND THE DELETE TRASH CAN ON THE CARDS HERE?

    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
//                    binding.enterText.setText(it[0].contactName)
//                    binding.enterPhone.setText(it[0].phoneNumber)
                } else {
                    val text = "There was a problem finding all the contacts."
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(this, text, duration)
                    toast.show()
                }
            }

        }
        viewModel.getSearchResults().observe(this) { contacts ->
            contacts?.let{
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    val text = "No Match to your search"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(this, text, duration)
                    toast.show()
                }
            }
        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener{
            override fun onClick(id: String) {
                var contactId: Int = Integer.parseInt(id)
                viewModel.deleteContact(contactId)
                clearFields()
            }
        })

    }




}