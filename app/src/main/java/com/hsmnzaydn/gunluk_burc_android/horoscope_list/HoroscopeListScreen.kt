package com.hsmnzaydn.gunluk_burc_android.horoscope_list


import android.view.Gravity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.NavController
import com.hsmnzaydn.gunluk_burc_android.R
import com.hsmnzaydn.gunluk_burc_android.data.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.fake.FakeHoroscopeListViewModel
import com.hsmnzaydn.gunluk_burc_android.fake.FakeNavController
import com.hsmnzaydn.gunluk_burc_android.splash.NavControllerAndSplashViewModelProvider
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Purple200
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Purple700
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Typography
import com.hsmnzaydn.gunluk_burc_android.widgets.HoroscopeWidget
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.NonDisposableHandle.parent
@Preview
@Composable
fun HoroscopeListScreen(
    @PreviewParameter(FakeHoroscopeListViewModel::class) viewModel: HoroscopeListViewModel
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
            viewModel.fetchHoroscopes()
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
        items(viewModel._horocopeList.value) { item ->
            HoroscopeWidget(item = item)

        }
    }
}







