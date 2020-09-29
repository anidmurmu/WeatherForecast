package com.example.domain.model

data class
CurrentWeatherUiModel (
    var latitude: String,
    var longitude: String,
    var city: String,
    var country: String,
    var date: String,
    var temperature: String,
    var feelsLike: String,
    var pressure: String,
    var humidity: String,
    var windSpeed: String,
    var visibility: String
)