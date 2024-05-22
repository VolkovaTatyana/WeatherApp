package com.example.weatherapp.data.repository

import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.domain.repository.SearchRepository

class SearchRepositoryImpl : SearchRepository {
    override suspend fun search(query: String): List<City> {
        TODO("Not yet implemented")
    }
}