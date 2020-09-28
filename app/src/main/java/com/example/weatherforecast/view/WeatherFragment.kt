package com.example.weatherforecast.view

import androidx.lifecycle.LiveData
import com.example.domain.base.BaseViewState
import com.example.ui.base.DataBindingBaseFragment
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.FragmentWeatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : DataBindingBaseFragment<FragmentWeatherBinding>() {
    private val model: WeatherViewModel by viewModel()

    override val layoutResource: Int
        get() = R.layout.fragment_weather

    override fun onViewDataBindingCreated(binding: FragmentWeatherBinding) {
        binding.viewModel = model
        model.init()
        model.getGetCurrentWeather("delhi")
    }

    override fun setBaseStates() {
        loadingState = model.weatherInfo as LiveData<BaseViewState<*>>
    }
}