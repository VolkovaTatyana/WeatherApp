package com.example.weatherapp.data.repository

import com.example.weatherapp.domain.entity.Forecast
import com.example.weatherapp.domain.entity.Weather
import com.example.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl : WeatherRepository {
    override suspend fun getWeather(cityId: Int): Weather {
        TODO("Not yet implemented")
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        TODO("Not yet implemented")
    }
}