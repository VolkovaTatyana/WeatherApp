package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.example.weatherapp.data.network.api.ApiFactory
import com.example.weatherapp.domain.usecase.ChangeFavouriteStateUseCase
import com.example.weatherapp.domain.usecase.SearchCityUseCase
import com.example.weatherapp.presentation.root.DefaultRootComponent
import com.example.weatherapp.presentation.root.RootContent
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory

    @Inject
    lateinit var searchCityUseCase: SearchCityUseCase

    @Inject
    lateinit var changeFavouriteStateUseCase: ChangeFavouriteStateUseCase


    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)

        super.onCreate(savedInstanceState)

        val scope = CoroutineScope(Dispatchers.Main)

        scope.launch {
            searchCityUseCase("lon").forEach {
                changeFavouriteStateUseCase.addToFavourite(it)
            }
        }

        setContent {
            RootContent(component = rootComponentFactory.create(defaultComponentContext()))
        }
    }
}
