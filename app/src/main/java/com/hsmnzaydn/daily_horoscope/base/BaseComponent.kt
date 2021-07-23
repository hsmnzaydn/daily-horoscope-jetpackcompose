package com.hsmnzaydn.daily_horoscope.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hsmnzaydn.daily_horoscope.ui.theme.GunlukburcandroidTheme

@Composable
fun BaseComponent(content: @Composable () -> Unit) {

    GunlukburcandroidTheme() {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxHeight(1f)
                .fillMaxWidth(1f)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun SimpleCircularProgressIndicator() {
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator()
    }
}