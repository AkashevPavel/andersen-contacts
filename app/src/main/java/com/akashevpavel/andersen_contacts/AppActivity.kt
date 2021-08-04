package com.akashevpavel.andersen_contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AppActivity : AppCompatActivity(), ContactsFragment.OnContactClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        supportFragmentManager.beginTransaction().run {
            replace(R.id.frame, ContactsFragment.newInstance(), ContactsFragment.TAG)
            this.commit()

        }


    }

    override fun onContactClicked(contact: Contact) {
        supportFragmentManager.beginTransaction().run {
            replace(R.id.frame, ContactInfoFragment.newInstance(contact), ContactInfoFragment.TAG)
            addToBackStack(ContactInfoFragment.TAG)
            this.commit()
        }
    }
}