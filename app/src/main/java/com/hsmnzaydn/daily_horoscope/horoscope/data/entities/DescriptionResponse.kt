package com.hsmnzaydn.daily_horoscope.horoscope.data.entities

import com.google.gson.annotations.SerializedName

data class DescriptionResponse(
    @SerializedName("description")
    var description: String,
    @SerializedName("title")
    var title: String
)