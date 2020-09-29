package com.example.data.network.service

import com.example.data.network.model.WeatherModelResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface WeatherService {
    @Headers("Content-Type: application/json")
    @GET("weather/")
    fun getCurrentWeather(@Query("q") city: String): Observable<WeatherModelResponse>
}