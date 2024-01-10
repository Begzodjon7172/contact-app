package com.example.contactappdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactappdb.adapters.ContactAdapter
import com.example.contactappdb.database.MyDbHelper
import com.example.contactappdb.databinding.ActivityListContactBinding
import com.example.contactappdb.models.Contact

class ListContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListContactBinding

    private lateinit var contactList: ArrayList<Contact>
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Barcha kontaktlar"

    }

    override fun onResume() {
        super.onResume()
        myDbHelper = MyDbHelper(this)
        contactList = ArrayList(myDbHelper.listContacts())

        binding.apply {
            contactAdapter = ContactAdapter(contactList)
            rv.adapter = contactAdapter

        }
    }
}