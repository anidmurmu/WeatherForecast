package com.example.weatherforecast.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.base.BaseViewState
import com.example.domain.base.Status
import com.example.domain.model.CurrentWeatherUiModel


class WeatherViewState(status: Status, error: Throwable? = null, data: CurrentWeatherUiModel? = null) :
    BaseViewState<Any>(status, error, data){

    val temperature: LiveData<String> = MutableLiveData<String>(data?.temperature.toString())

}