package com.example.contactappdb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactappdb.databinding.ItemContactBinding
import com.example.contactappdb.models.Contact

class ContactAdapter(private val contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.Vh>() {

    inner class Vh(private val itemContactBinding: ItemContactBinding) :
        RecyclerView.ViewHolder(itemContactBinding.root) {
        fun onBind(contact: Contact) {
            itemContactBinding.tvName.text = contact.name
            itemContactBinding.tvNumber.text = contact.phoneNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(contactList[position])
    }
}