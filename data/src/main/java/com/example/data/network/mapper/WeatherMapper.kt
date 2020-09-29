package com.example.data.network.mapper

import com.example.data.network.model.WeatherModelResponse
import com.example.domain.base.Mapper
import com.example.domain.model.CurrentWeatherUiModel

class WeatherModelResponseMapper : Mapper<WeatherModelResponse, CurrentWeatherUiModel>
{
    override fun mapFrom(type: WeatherModelResponse): CurrentWeatherUiModel {
        return CurrentWeatherUiModel(
            type.coordinate?.latitude.toString(),
                    type.coordinate?.longitude.toString(),
            type.cityName,
            type.sys?.country.toString(),
            "Today",
            type.main?.temperature.toString(),
            type.main?.feelsLike.toString(),
            type.main?.pressure.toString(),
            type.main?.humidity.toString(),
            type.wind?.speed.toString(),
            type.visibility.toString()
            )
    }
}