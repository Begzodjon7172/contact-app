package com.example.contactappdb.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.contactappdb.models.Contact

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION),
    DatabaseService {

    companion object {
        const val DB_NAME = "contactApp"
        const val DB_VERSION = 1

        const val TABLE_NAME = "contact"
        const val CONTACT_ID = "id"
        const val CONTACT_NAME = "name"
        const val CONTACT_NUMBER = "phone_number"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table $TABLE_NAME ($CONTACT_ID integer not null primary key autoincrement, $CONTACT_NAME text not null, $CONTACT_NUMBER text not null unique)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun addContact(contact: Contact) {
        val database = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(CONTACT_NAME, contact.name)
        contentValues.put(CONTACT_NUMBER, contact.phoneNumber)

        database.insert(TABLE_NAME, null, contentValues)
    }

    override fun listContacts(): List<Contact> {
        val contactList = ArrayList<Contact>()

        val database = this.readableDatabase
        val cursor = database.rawQuery("select * from $TABLE_NAME", null)
        if (cursor.moveToFirst()) {

            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val phoneNumber = cursor.getString(2)

                val contact = Contact(id, name, phoneNumber)
                contactList.add(contact)
            } while (cursor.moveToNext())

        }
        return contactList
    }
}