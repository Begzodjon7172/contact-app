package com.example.contactappdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactappdb.database.MyDbHelper
import com.example.contactappdb.databinding.ActivityAddContactBinding
import com.example.contactappdb.models.Contact

class AddContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddContactBinding
    private lateinit var myDbHelper: MyDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Kontakt qo'shish"

        myDbHelper = MyDbHelper(this)

        binding.apply {

            addBtn.setOnClickListener {

                if (isValid()) {
                    val name = edtName.text.toString()
                    val number = edtNumber.text.toString()
                    val contact = Contact(name = name, phoneNumber = number)
                    myDbHelper.addContact(contact)
                    Toast.makeText(this@AddContactActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                    finish()
                }


            }


        }


    }

    private fun isValid(): Boolean {
        binding.apply {
            return if (edtName.text.isEmpty()) {
                Toast.makeText(this@AddContactActivity, "Ism kiritilmagan", Toast.LENGTH_SHORT)
                    .show()
                false
            } else if (edtNumber.text.isEmpty()) {
                Toast.makeText(this@AddContactActivity, "Raqam kiritilmagan", Toast.LENGTH_SHORT)
                    .show()
                false
            } else true
        }
    }
}