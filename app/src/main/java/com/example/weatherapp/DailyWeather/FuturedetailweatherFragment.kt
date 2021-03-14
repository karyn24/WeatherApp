package com.example.weatherapp.DailyWeather

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.weatherapp.R

class FuturedetailweatherFragment : Fragment() {

    companion object {
        fun newInstance() = FuturedetailweatherFragment()
    }

    private lateinit var viewModel: FuturedetailweatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.futuredetailweather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FuturedetailweatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
