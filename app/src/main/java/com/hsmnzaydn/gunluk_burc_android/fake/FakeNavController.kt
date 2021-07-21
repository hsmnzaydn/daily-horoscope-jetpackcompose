package com.hsmnzaydn.gunluk_burc_android.fake

import android.app.Application
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.NavController
import com.hsmnzaydn.gunluk_burc_android.horoscope_list.HoroscopeListViewModel
import com.hsmnzaydn.gunluk_burc_android.splash.SplashViewModel
import javax.inject.Inject

class FakeNavController: PreviewParameterProvider<NavController> {
    override val values = sequenceOf(NavController(Application()))
    override val count: Int = values.count()

}

class FakeSplashViewModel: PreviewParameterProvider<SplashViewModel> {
    override val values = sequenceOf(SplashViewModel())
    override val count: Int = values.count()

}

class FakeHoroscopeListViewModel @Inject constructor(horoscopeListViewModel: HoroscopeListViewModel): PreviewParameterProvider<HoroscopeListViewModel> {
    override val values = sequenceOf(horoscopeListViewModel)
    override val count: Int = values.count()

}

open class PreviewParameterCombiner<T, U>(
    private val first: PreviewParameterProvider<T>,
    private val second: PreviewParameterProvider<U>,
) : PreviewParameterProvider<Pair<T, U>> {
    override val values = first.values.flatMap { firstValue ->
        second.values.map { secondValue ->
            firstValue to secondValue
        }
    }
}

