package com.hsmnzaydn.gunluk_burc_android.ui.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Description
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Typography

@Composable
fun HoroscopeDetailWidget(description: Description){
    Text(text = description.title,Modifier.padding(top = 16.dp,start = 8.dp,end = 8.dp))
    Text(text = description.description,Modifier.padding(top = 8.dp,start = 8.dp,end = 8.dp),style = Typography.body2)
}