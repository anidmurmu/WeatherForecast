package com.example.data.network.mapper

import com.example.data.network.model.WeatherModelResponse
import com.example.domain.base.Mapper
import com.example.domain.model.CurrentWeatherUiModel

class WeatherModelResponseMapper : Mapper<WeatherModelResponse, CurrentWeatherUiModel>
{
    override fun mapFrom(type: WeatherModelResponse): CurrentWeatherUiModel {
        return CurrentWeatherUiModel(type.main?.temperature ?: 0.0)
    }
}