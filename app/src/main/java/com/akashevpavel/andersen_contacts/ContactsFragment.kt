package com.akashevpavel.andersen_contacts

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.io.Serializable

class ContactsFragment : Fragment() {

    private lateinit var contactClickListener: OnContactClickListener

    private val firstContact = Contact("Mary", "Jane", "+1 000 345 7")
    private val secondContact = Contact("Piter", "Parker", "+2 000 638 2")
    private val thirdContact = Contact("Spider", "Man", "+3 000 765 8")

    override fun onAttach(context: Context) {
        super.onAttach(context)

        contactClickListener = context as OnContactClickListener
    }

    companion object {
        const val TAG = "CONTACTS_FRAGMENT"
        fun newInstance() = ContactsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_contacts, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<LinearLayout>(R.id.firstContact).setOnClickListener {
            contactClickListener.onContactClicked(firstContact)
        }

        view.findViewById<LinearLayout>(R.id.secondContact).setOnClickListener {
            contactClickListener.onContactClicked(secondContact)
        }

        view.findViewById<LinearLayout>(R.id.thirdContact).setOnClickListener {
            contactClickListener.onContactClicked(thirdContact)
        }

    }

    interface OnContactClickListener {
        fun onContactClicked(contact: Contact)
    }

}

data class Contact(val name: String, val surname: String, val phoneNumber: String) : Serializable