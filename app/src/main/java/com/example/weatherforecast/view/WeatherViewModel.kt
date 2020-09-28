package com.example.weatherforecast.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.base.Status
import com.example.domain.usecase.GetCurrentWeatherUseCase
import com.example.ui.base.RxAwareViewModel
import com.example.ui.base.ViewOnClickListener

class WeatherViewModel(private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase) : RxAwareViewModel(), ViewOnClickListener {

    private val _weatherInfoMutableLiveData = MutableLiveData<WeatherViewState>()
    val weatherInfo: LiveData<WeatherViewState> = _weatherInfoMutableLiveData

    fun init() {
        _weatherInfoMutableLiveData.value = WeatherViewState(Status.LOADING)
    }

}