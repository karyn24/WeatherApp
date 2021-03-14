package com.example.weatherapp

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*


  // this activity displays the first screen the user sees

class MainActivity : AppCompatActivity() {
    val CITY: String = "Cape Town"
    val API: String = "809e00c2c6fad4241dfac7cca98aeabe"
    var done:Int = -1
    var position:Int =0
    var theIntent:Intent = Intent()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val button = findViewById<Button>(R.id.Next)
        button.setOnClickListener{
            theIntent = Intent(this, CitiesActivity::class.java)
            startActivity(theIntent)
        }

         weatherTask().execute()
    }

     inner class weatherTask(): AsyncTask<String,Void, String>() {
         override fun onPreExecute() {
             super.onPreExecute()
         }
         override fun doInBackground(vararg params: String?): String? {
             var response:String?
             try{
                 response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
                 Charsets.UTF_8
                 )
             }catch (e: Exception){
                 response = "12345"
             }
             return response
         }

         override fun onPostExecute(result: String?) {
             super.onPostExecute(result)
             try {
                 val jsonObj = JSONObject(result)
                 val main = jsonObj.getJSONObject("main")

                 val temp = main.getString("temp") + "\u2103"
                 val temp_min = "Temp min " + main.getString("temp_min") + "\u2103"
                 val temp_max = "Temp max " +main.getString("temp_max") + "\u2103"
                 val wind = jsonObj.getJSONObject("wind")
                 val speed = "Wind speed " +wind.getString("speed") +"mph"
                 val sys = jsonObj.getJSONObject("sys")
                 val address = jsonObj.getString("name") + "," + sys.getString("country")
                 val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
                 val description = weather.getString("description")
                 val dt = jsonObj.getLong("dt")
                 val updatedAtText = " "+ SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(dt*1000))

                 findViewById<TextView>(R.id.degrees).text = temp
                 findViewById<TextView>(R.id.maxTemp).text = temp_max
                 findViewById<TextView>(R.id.minTemp).text = temp_min
                 findViewById<TextView>(R.id.speed).text = speed
                 findViewById<TextView>(R.id.cityName).text = address
                 findViewById<TextView>(R.id.description).text =description
                 findViewById<TextView>(R.id.date).text = updatedAtText


                 findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE

             } catch (e: Exception) {

             }

         }
     }
}




