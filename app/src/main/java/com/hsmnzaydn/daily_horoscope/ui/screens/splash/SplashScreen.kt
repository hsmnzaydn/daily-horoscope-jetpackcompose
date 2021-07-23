package com.hsmnzaydn.daily_horoscope.ui.screens.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.daily_horoscope.ui.theme.Purple200
import com.hsmnzaydn.daily_horoscope.ui.theme.Typography
import com.hsmnzaydn.daily_horoscope.util.Navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.hsmnzaydn.daily_horoscope.R

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.ic_logo),colorFilter = ColorFilter.tint(
            Purple200), contentDescription = null)
        Text(
            stringResource(id = R.string.app_name),
            Modifier.padding(top = 8.dp),
            style = Typography.h1
        )
        GlobalScope.launch(Dispatchers.Main) {
            delay(3000L)
            navController.popBackStack()
            navController.navigate(Navigation.HOROSCOPE_LIST_SCREEN.name)

        }

    }

}



