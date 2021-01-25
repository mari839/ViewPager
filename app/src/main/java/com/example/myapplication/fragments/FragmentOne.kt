package com.example.myapplication.fragments
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.R
import java.net.URL


class FragmentOne : Fragment(R.layout.fragment_one){

    fun test(){
        var nameTextView:TextView = requireView().findViewById(R.id.nameTextView)
        var lastnameTextView: TextView = requireView().findViewById(R.id.lastnameTextView)
        var imageView2: ImageView = requireView().findViewById(R.id.imageView2)

        val sharedPrefs = requireContext().getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE)
        val name = sharedPrefs.getString("name", "default value")
        val lastname = sharedPrefs.getString("lastName","default value")
        val imageUrl = sharedPrefs.getString("imageUrl","default value")

        Glide.with(requireContext())
                .load(imageUrl)
                .centerInside()
                .into(imageView2)


        nameTextView.text = name;
        lastnameTextView.text = lastname;
    }
}

