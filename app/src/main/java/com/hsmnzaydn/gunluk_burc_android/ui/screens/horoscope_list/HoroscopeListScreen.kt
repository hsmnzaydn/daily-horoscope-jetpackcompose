package com.hsmnzaydn.gunluk_burc_android.ui.screens.horoscope_list


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
import com.hsmnzaydn.gunluk_burc_android.R
import com.hsmnzaydn.gunluk_burc_android.base.SimpleCircularProgressIndicator
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Purple200
import com.hsmnzaydn.gunluk_burc_android.ui.widgets.HoroscopeWidget

@ExperimentalMaterialApi
@Composable
fun HoroscopeListScreen(
    navigation: NavController,
    viewModel: HoroscopeListViewModel
) {
    Column(
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
        if (viewModel.horocopeList.value.size < 0) {
            SimpleCircularProgressIndicator()
        } else {
            HoroscopeList(viewModel.horocopeList.value)
        }

    }
}

@ExperimentalMaterialApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HoroscopeList(horoscopeList: List<Horoscope>) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.padding(top = 16.dp)) {
        items(horoscopeList) { item ->
            HoroscopeWidget(item = item, click = {

            })
        }
    }

}













