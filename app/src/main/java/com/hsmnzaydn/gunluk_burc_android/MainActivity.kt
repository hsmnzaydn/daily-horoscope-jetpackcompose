package com.hsmnzaydn.gunluk_burc_android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.hsmnzaydn.gunluk_burc_android.horoscope_list.HoroscopeListScreen
import com.hsmnzaydn.gunluk_burc_android.horoscope_list.HoroscopeListViewModel
import com.hsmnzaydn.gunluk_burc_android.splash.SplashScreen
import com.hsmnzaydn.gunluk_burc_android.splash.SplashViewModel
import com.hsmnzaydn.gunluk_burc_android.ui.theme.GunlukburcandroidTheme
import com.hsmnzaydn.gunluk_burc_android.util.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GunlukburcandroidTheme(
            ) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Navigation.SPLASH_SCREEN.name
                ) {
                    composable(Navigation.SPLASH_SCREEN.name) {
                        SplashScreen(navController, hiltViewModel())

                    }
                    composable(
                        Navigation.HOROSCOPE_LIST_SCREEN.name){
                        HoroscopeListScreen( navController,hiltViewModel<HoroscopeListViewModel>())

                    }

                }



            }

        }

    }

}



