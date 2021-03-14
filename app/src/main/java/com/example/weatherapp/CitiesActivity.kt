package com.example.weatherapp

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import org.json.JSONObject
import java.net.URL





class CitiesActivity : AppCompatActivity() {
    var City : String = "London"
    var Temp : String = "30"

    val API: String = "809e00c2c6fad4241dfac7cca98aeabe"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        var listview = findViewById<ListView>(R.id.Listview)

        var list = mutableListOf<Model>()

        var cities: Array<String> = arrayOf("Lisbon","Madrid","Paris","Berlin","Copenhagen","Rome","London","Dublin","Prague","Vienna")
        var timer: String = ""

        weatherTask().execute()
        for (aCity in cities){
            City = aCity
            //adding the following inside the listview
            list.add(Model(aCity,Temp+"\u2103",  R.drawable.cloudsun))

        }

        listview.adapter = MyAdapter(this, R.layout.aound, list)

        //when listview is clicked it will open an activity showing the city and its current weather
        listview.setOnItemClickListener { parent: AdapterView<*>, view:View, position:Int, id:Long ->

            val intent = Intent(this@CitiesActivity, LisbonActivity::class.java)
            when (position) {
                0 -> intent.putExtra("theCity", "Lisbon")
                1 -> intent.putExtra("theCity", "Madrid")
                2 -> intent.putExtra("theCity", "Paris")
                3 -> intent.putExtra("theCity", "Berlin")
                4 -> intent.putExtra("theCity", "Copenhagen")    //the cities that will appear in the listview
                5 -> intent.putExtra("theCity", "Rome")
                6 -> intent.putExtra("theCity", "London")
                7 -> intent.putExtra("theCity", "Dublin")
                8 -> intent.putExtra("theCity", "Prague")
                9 -> intent.putExtra("theCity", "vienna")
                else -> intent.putExtra("theCity", "Cape Town")
            }
            startActivity (intent)
        }
    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                Temp = (0..30).random().toString()

                //getting current weather from the openweathermap using the api listed above
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$City&units=metric&appid=$API").
                readText(Charsets.UTF_8)

            } catch (e: Exception) {
                response = "12345"
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {

               //connecting weather information using jsonobject
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                 Temp = main.getString("temp")

                findViewById<TextView>(R.id.temperature).text = Temp + "\u2103"


            } catch (e: Exception) {

            }

        }
    }

}


