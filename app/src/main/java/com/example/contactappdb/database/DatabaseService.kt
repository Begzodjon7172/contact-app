package com.example.contactappdb.database

import com.example.contactappdb.models.Contact

interface DatabaseService {

    fun addContact(contact: Contact)

    fun listContacts(): List<Contact>
}