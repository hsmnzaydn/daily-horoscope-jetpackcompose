package com.hsmnzaydn.gunluk_burc_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hsmnzaydn.gunluk_burc_android.base.BaseComponent
import com.hsmnzaydn.gunluk_burc_android.ui.screens.horoscope_list.HoroscopeListScreen
import com.hsmnzaydn.gunluk_burc_android.ui.screens.splash.SplashScreen
import com.hsmnzaydn.gunluk_burc_android.ui.theme.GunlukburcandroidTheme
import com.hsmnzaydn.gunluk_burc_android.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

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
                        BaseComponent {
                            SplashScreen(navController, hiltViewModel())
                        }
                    }
                    composable(
                        Navigation.HOROSCOPE_LIST_SCREEN.name){
                        BaseComponent {
                            HoroscopeListScreen( navController,hiltViewModel())
                        }
                    }
                }
            }
        }
    }
}



