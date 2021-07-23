package com.hsmnzaydn.daily_horoscope.horoscope.data.api

import com.hsmnzaydn.daily_horoscope.horoscope.data.entities.HoroscopeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface HoroscopeServices {
    @GET("horoscopes")
    suspend fun getHoroscopes(@Query("date") date:Long) : Response<List<HoroscopeResponse>>

    @GET("horoscopes/{id}")
    suspend fun getHoroscopeDetail(@Path("id") horoscopeId:String): Response<HoroscopeResponse>
}