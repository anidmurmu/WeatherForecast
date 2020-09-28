package com.example.domain.repository

import com.example.domain.base.Resource
import com.example.domain.model.CurrentWeatherUiModel
import io.reactivex.rxjava3.core.Observable

interface WeatherRepository {

    fun getCurrentWeather(city: String): Observable<Resource<CurrentWeatherUiModel>>
}