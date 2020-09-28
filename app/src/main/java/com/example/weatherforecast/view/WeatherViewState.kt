package com.example.weatherforecast.view

import com.example.domain.base.BaseViewState
import com.example.domain.base.Status

class WeatherViewState(status: Status, error: Throwable? = null, data: Any? = null) :
    BaseViewState<Any>(status, error, data){

}