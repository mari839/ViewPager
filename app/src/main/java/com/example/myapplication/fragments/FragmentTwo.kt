package com.example.myapplication.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.PersonInfo
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FragmentTwo : Fragment(R.layout.fragment_two) {

    private lateinit var nameEditText: EditText
    private lateinit var lastnameEditText: EditText
    private lateinit var urlEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var imageView: ImageView

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText = requireView().findViewById(R.id.nameEditText)
        lastnameEditText = requireView().findViewById(R.id.lastnameEditText)
        urlEditText = requireView().findViewById(R.id.urlEditText)
        saveButton = requireView().findViewById(R.id.saveButton)
        imageView = requireView().findViewById(R.id.imageView)


        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val lastName = lastnameEditText.text.toString()
            val imageUrl = urlEditText.text.toString()

            val sharedPrefs = requireContext().getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString("name", name)
            editor.putString("lastName", lastName)
            editor.putString("imageUrl", imageUrl)
            editor.apply()

            requireActivity().supportFragmentManager.fragments.filter { it is FragmentOne }.firstOrNull()?.let { (it as FragmentOne).test() }
        }
    }
}