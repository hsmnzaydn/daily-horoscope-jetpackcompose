package com.hsmnzaydn.daily_horoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.hsmnzaydn.daily_horoscope.base.BaseComponent
import com.hsmnzaydn.daily_horoscope.ui.screens.horoscope_detail.HoroscopeDetailScreen
import com.hsmnzaydn.daily_horoscope.ui.screens.horoscope_list.HoroscopeListScreen
import com.hsmnzaydn.daily_horoscope.ui.screens.splash.SplashScreen
import com.hsmnzaydn.daily_horoscope.ui.theme.GunlukburcandroidTheme
import com.hsmnzaydn.daily_horoscope.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
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
                    composable("${Navigation.HOROSCOPE_DETAIL_SCREEN.name}/{horoscopeId}",arguments =
                    listOf(
                        navArgument("horoscopeId"){
                            type = NavType.StringType
                        }
                    )){
                        BaseComponent {
                            HoroscopeDetailScreen(navigation = navController, viewModel = hiltViewModel(), it.arguments?.getString("horoscopeId", "1")?:"")
                        }
                    }

                }
            }
        }
    }
}



