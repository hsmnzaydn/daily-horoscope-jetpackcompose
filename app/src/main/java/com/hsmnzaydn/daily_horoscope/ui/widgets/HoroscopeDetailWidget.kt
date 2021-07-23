package com.hsmnzaydn.daily_horoscope.ui.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Description
import com.hsmnzaydn.daily_horoscope.ui.theme.Typography

@Composable
fun HoroscopeDetailWidget(description: Description){
    Text(text = description.title,Modifier.padding(top = 16.dp,start = 8.dp,end = 8.dp))
    Text(text = description.description,Modifier.padding(top = 8.dp,start = 8.dp,end = 8.dp),style = Typography.body2)
}

@Preview
@Composable
fun detailListPreview(){
   HoroscopeDetailWidget(description = Description("Daily Horoscope","Daily")) 
}