package com.hsmnzaydn.gunluk_burc_android.ui.screens.horoscope_detail


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.gunluk_burc_android.R
import com.hsmnzaydn.gunluk_burc_android.base.Result
import com.hsmnzaydn.gunluk_burc_android.base.SimpleCircularProgressIndicator
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Purple200
import com.hsmnzaydn.gunluk_burc_android.ui.widgets.HoroscopeWidget
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterialApi
@Composable
fun HoroscopeDetailScreen(
    navigation: NavController,
    viewModel: HoroscopeDetailViewModel,
    horoscopeId: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        viewModel.fetchHoroscope(horoscopeId)

        when(viewModel.horoscope.value.status){
            Result.Status.LOADING -> {
                CircularProgressIndicator()
            }
            Result.Status.SUCCESS ->{
                contentDetail(horoscope = viewModel.horoscope.value.data!!)
            }

        }

    }


}

@Composable
fun contentDetail(horoscope: Horoscope){
    GlideImage(
        imageModel = horoscope.imagePath,
        contentDescription = horoscope.title,
        modifier =
        Modifier
            .alpha(0.8f)
            .width(200.dp)
            .height(100.dp)
    )


    Text(horoscope.descriptions[0].title)
}















