package com.example.basicweatherapp.weatherfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basicweatherapp.R
import com.example.basicweatherapp.databinding.FragmentWeatherBinding
import com.example.basicweatherapp.domain.DayWeather

class WeatherFragment : Fragment() {

    private val viewModel: WeatherFragmentViewModel by lazy {
        ViewModelProvider(this).get(WeatherFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentWeatherBinding.inflate(inflater)

        viewModel.currentWeather?.observe(viewLifecycleOwner, Observer {
            binding.currentWeather = it
        })

        viewModel.weeklyWeather?.observe(viewLifecycleOwner, Observer {
            binding.viewModel = viewModel
        })

        binding.recyclerViewDays.adapter = WeatherRecyclerViewAdapter()

        return binding.root
    }
}