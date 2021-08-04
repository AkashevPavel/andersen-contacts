package com.akashevpavel.andersen_contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ContactInfoFragment : Fragment() {

    private lateinit var mName: TextView
    private lateinit var mSurname: TextView
    private lateinit var mPhoneNumber: TextView

    private lateinit var contact: Contact

    companion object {
        const val TAG = "CONTACT_INFO_FRAGMENT"
        private const val CONTACT_KEY = "CONTACT_KEY"

        fun newInstance(contact: Contact): ContactInfoFragment {
            val contactInfoFragment = ContactInfoFragment()
            val bundle = Bundle()
            bundle.putSerializable(CONTACT_KEY, contact)
            contactInfoFragment.arguments = bundle
            return contactInfoFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_contact_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contact = arguments?.getSerializable(CONTACT_KEY) as Contact
        mName = view.findViewById(R.id.contactName)
        mName.text = contact.name
        mSurname = view.findViewById(R.id.contactSurname)
        mSurname.text = contact.surname
        mPhoneNumber = view.findViewById(R.id.contactPhoneNumber)
        mPhoneNumber.text = contact.phoneNumber
    }
}