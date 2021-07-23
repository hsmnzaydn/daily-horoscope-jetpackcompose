package com.hsmnzaydn.gunluk_burc_android.horoscope_list


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.gunluk_burc_android.R
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Purple200
import com.hsmnzaydn.gunluk_burc_android.util.Navigation
import com.hsmnzaydn.gunluk_burc_android.widgets.HoroscopeWidget

@Composable
fun HoroscopeListScreen(
    navigation: NavController,
     viewModel: HoroscopeListViewModel
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Purple200)
                .fillMaxHeight(1f)
                .fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.ic_logo), contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(top = 32.dp)
            )
            HoroscopeList( viewModel = viewModel)
        }

    }


}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HoroscopeList( viewModel: HoroscopeListViewModel) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.padding(top = 16.dp)) {
        items(viewModel.horocopeList.value) { item ->
            HoroscopeWidget(item = item)

        }
    }
}







