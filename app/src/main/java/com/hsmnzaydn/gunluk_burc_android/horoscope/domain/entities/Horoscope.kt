package com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities

data class Horoscope(
    val imagePath: String,
    val id: String,
    val title: String,
    val descriptions:List<Description>
)
