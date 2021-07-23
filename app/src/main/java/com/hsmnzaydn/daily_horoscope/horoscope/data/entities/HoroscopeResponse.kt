package com.hsmnzaydn.daily_horoscope.horoscope.data.entities

import com.google.gson.annotations.SerializedName

data class HoroscopeResponse(
    @SerializedName("horoscopeName")
    var horoscopeName: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("imagePath")
    var imagePath: String,
    @SerializedName("description")
    var descriptionResponse: List<DescriptionResponse>
)