package com.example.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
//import com.example.navapplication.R
import com.example.weatherappimport.Lisbonviewmodel

class Lisbon1 : Fragment() {

    private lateinit var Lisbonviewmodel: Lisbonviewmodel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* com.example.weatherappimport.Lisbonviewmodel =
            ViewModelProviders.of(this).get(com.example.weatherappimport.Lisbonviewmodel::class.java)
        val root = inflater.inflate(R.layout.activity_lisbon, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        com.example.weatherappimport.Lisbonviewmodel.text.observe(this, Observer {
            textView.text = it
        })*/
        return null
    }

}