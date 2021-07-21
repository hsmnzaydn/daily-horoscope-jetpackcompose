package com.hsmnzaydn.gunluk_burc_android.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HoroscopeApi {

    @GET("horoscopes")
    suspend fun getHoroscopes(@Query("date") date:Long) : Response<List<HoroscopeResponse>>
}