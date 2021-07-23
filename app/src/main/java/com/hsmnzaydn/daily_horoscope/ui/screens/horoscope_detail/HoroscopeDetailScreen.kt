package com.hsmnzaydn.daily_horoscope.ui.screens.horoscope_detail


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.daily_horoscope.base.Result
import com.hsmnzaydn.daily_horoscope.base.SimpleCircularProgressIndicator
import com.hsmnzaydn.daily_horoscope.fake.FakeHoroscope
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Description
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.daily_horoscope.ui.widgets.HoroscopeDetailWidget
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterialApi
@Composable
fun HoroscopeDetailScreen(
    navigation: NavController,
    viewModel: HoroscopeDetailViewModel,
    horoscopeId: String
) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        viewModel.fetchHoroscope(horoscopeId)

        when(viewModel.horoscope.value.status){
            Result.Status.LOADING -> {
                SimpleCircularProgressIndicator()
            }
            Result.Status.SUCCESS ->{
                contentDetail(horoscope = viewModel.horoscope.value.data!!)
            }

        }

    }


}

@Preview
@Composable
fun contentDetail(@PreviewParameter(FakeHoroscope::class) horoscope: Horoscope){
    GlideImage(
        imageModel = horoscope.imagePath,
        contentDescription = horoscope.title,
        modifier =
        Modifier
            .alpha(0.8f)
            .fillMaxWidth()
            .height(200.dp)
    )
    HoroscopeDetailList(descriptionList = horoscope.descriptions)

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HoroscopeDetailList( descriptionList: List<Description>) {
    LazyColumn() {
        items(descriptionList){
            HoroscopeDetailWidget(it)
        }
    }
}















