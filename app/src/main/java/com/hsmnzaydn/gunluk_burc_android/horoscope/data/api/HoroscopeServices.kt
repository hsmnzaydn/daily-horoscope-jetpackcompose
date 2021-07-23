package com.hsmnzaydn.gunluk_burc_android.horoscope.data.api

import com.hsmnzaydn.gunluk_burc_android.horoscope.data.entities.HoroscopeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface HoroscopeServices {
    @GET("horoscopes")
    suspend fun getHoroscopes(@Query("date") date:Long) : Response<List<HoroscopeResponse>>
}