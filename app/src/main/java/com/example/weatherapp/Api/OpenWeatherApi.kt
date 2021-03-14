package com.example.weatherapp.Api

import android.telecom.Call
import com.example.weatherapp.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {

  /*  @GET("forecast/daily/")
  //  fun dailyForecast(@Query("q") cityName : String, @Query("cnt") dayCount : Int) : Call<WeatherResponse>

    companion object {
        val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    }
}

class OpenWeatherInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
     //   val url: HttpUrl = chain.request().url().newBuilder().addQueryParameter("APPID", BuildConfig.OPEN_WEATHER_API_KEY).
        addQueryParameter("mode", "json").
        addQueryParameter("units", "metric").build()
        return chain.proceed(chain.request().newBuilder().addHeader("Accept", "application/json").url(url).build())
    }*/

}