package com.hsmnzaydn.daily_horoscope.ui.screens.horoscope_list


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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.daily_horoscope.R
import com.hsmnzaydn.daily_horoscope.base.Result
import com.hsmnzaydn.daily_horoscope.base.SimpleCircularProgressIndicator
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.daily_horoscope.ui.theme.Purple200
import com.hsmnzaydn.daily_horoscope.ui.widgets.HoroscopeWidget
import com.hsmnzaydn.daily_horoscope.util.Navigation

@ExperimentalMaterialApi
@Composable
fun HoroscopeListScreen(
    navigation: NavController,
    viewModel: HoroscopeListViewModel
) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.ic_logo), contentDescription = null,
            colorFilter = ColorFilter.tint(
                Purple200
            ),
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .padding(top = 32.dp)
        )
        when (viewModel.horocopeList?.value?.status) {
            Result.Status.LOADING -> {
                SimpleCircularProgressIndicator()
            }
            Result.Status.SUCCESS -> {
                viewModel.horocopeList.value.data?.let { HoroscopeList(navigation, it) }
            }
        }


    }
}

@ExperimentalMaterialApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HoroscopeList(navigation: NavController, horoscopeList: List<Horoscope>) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.padding(top = 16.dp)) {
        items(horoscopeList) { item ->
            HoroscopeWidget(item = item, click = {
                navigation.navigate("${Navigation.HOROSCOPE_DETAIL_SCREEN.name}/${item.id}")
            })
        }
    }

}













