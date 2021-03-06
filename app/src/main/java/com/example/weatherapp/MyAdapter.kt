package com.example.weatherapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (var mCtx: Context, var resources:Int, var items:List<Model>): ArrayAdapter<Model>(mCtx,resources,items) {
    override  fun getView(position:Int, convertView: View?, parent: ViewGroup): View{
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources,null)

        val imageView:ImageView = view.findViewById(R.id.weatherIcon)
        val titleTextView:TextView = view.findViewById(R.id.nameofcity)
        val descriptionTextView:TextView =  view.findViewById(R.id.temperature)

        var mItem:Model = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        titleTextView.text = mItem.title
        descriptionTextView.text = mItem.description

        return view

    }
}