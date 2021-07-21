package com.hsmnzaydn.gunluk_burc_android.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.gunluk_burc_android.R
import com.hsmnzaydn.gunluk_burc_android.fake.FakeNavController
import com.hsmnzaydn.gunluk_burc_android.fake.FakeSplashViewModel
import com.hsmnzaydn.gunluk_burc_android.fake.PreviewParameterCombiner
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Purple200
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Typography
import com.hsmnzaydn.gunluk_burc_android.util.Navigation
import kotlinx.coroutines.*

@Preview
@Composable
fun SplashScreen(
    @PreviewParameter(NavControllerAndSplashViewModelProvider::class)
    controllerAndViewModel: Pair<NavController, SplashViewModel>

) {
    Column(
        modifier = Modifier
            .background(Purple200)
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null)
        Text(
            stringResource(id = R.string.app_name),
            Modifier.padding(top = 8.dp),
            style = Typography.h1
        )
        GlobalScope.launch(Dispatchers.Main) {
            delay(3000L)
            controllerAndViewModel.first.popBackStack()
            controllerAndViewModel.first.navigate(Navigation.HOROSCOPE_LIST_SCREEN.name)

        }

    }

}

class NavControllerAndSplashViewModelProvider :
    PreviewParameterCombiner<NavController, SplashViewModel>(
        FakeNavController(),
        FakeSplashViewModel()
    )

