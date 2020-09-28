package com.example.data.network.model

import com.example.data.network.model.base.CloudBaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coordinate {
    @SerializedName("lon")
    @Expose(serialize = false)
    var longitude: Double? = 0.0

    @SerializedName("lat")
    @Expose(serialize = false)
    var latitude: Double? = 0.0
}

class Weather {
    @SerializedName("id")
    @Expose(serialize = false)
    var id: Int? = 0

    @SerializedName("main")
    @Expose(serialize = false)
    var main: String = ""

    @SerializedName("description")
    @Expose(serialize = false)
    var description: String = ""

    @SerializedName("icon")
    @Expose(serialize = false)
    var icon: String = ""
}

class Main {
    @SerializedName("temp")
    @Expose(serialize = false)
    var temperature: Double = 0.0

    @SerializedName("feels_like")
    @Expose(serialize = false)
    var feelsLike = 0.0

    @SerializedName("temp_min")
    @Expose(serialize = false)
    var tempMin = 0.0

    @SerializedName("temp_max")
    @Expose(serialize = false)
    var tempMax = 0.0

    @SerializedName("pressure")
    @Expose(serialize = false)
    var pressure = 0

    @SerializedName("humidity")
    @Expose(serialize = false)
    var humidity = 0
}

class Wind {
    @SerializedName("speed")
    @Expose(serialize = false)
    var speed = 0.0

    @SerializedName("deg")
    @Expose(serialize = false)
    var deg = 0
}

class Clouds {
    @SerializedName("all")
    @Expose(serialize = false)
    var all = 0
}

class Sys {
    @SerializedName("type")
    @Expose(serialize = false)
    var type = 0

    @SerializedName("id")
    @Expose(serialize = false)
    var id = 0

    @SerializedName("country")
    @Expose(serialize = false)
    var country: String = ""

    @SerializedName("sunrise")
    @Expose(serialize = false)
    var sunrise = 0

    @SerializedName("sunset")
    @Expose(serialize = false)
    var sunset = 0
}

class WeatherModelResponse :  CloudBaseResponse() {
    @SerializedName("coord")
    @Expose(serialize = false)
    var coordinate: Coordinate? = null

    @SerializedName("weather")
    @Expose(serialize = false)
    var weather: List<Weather> = emptyList()

    @SerializedName("base")
    @Expose(serialize = false)
    var base: String = ""

    @SerializedName("main")
    @Expose(serialize = false)
    var main: Main? = null

    @SerializedName("visibility")
    @Expose(serialize = false)
    var visibility = 0

    @SerializedName("wind")
    @Expose(serialize = false)
    var wind: Wind? = null

    @SerializedName("clouds")
    @Expose(serialize = false)
    var clouds: Clouds? = null

    @SerializedName("dt")
    @Expose(serialize = false)
    var dt = 0

    @SerializedName("sys")
    @Expose(serialize = false)
    var sys: Sys? = null

    @SerializedName("timezone")
    @Expose(serialize = false)
    var timezone = 0

    @SerializedName("id")
    @Expose(serialize = false)
    var id = 0

    @SerializedName("name")
    @Expose(serialize = false)
    var cityName: String = ""

    @SerializedName("cod")
    @Expose(serialize = false)
    var cod = 0
}

