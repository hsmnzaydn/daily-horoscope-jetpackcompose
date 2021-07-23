package com.hsmnzaydn.gunluk_burc_android.horoscope.domain.repository

import com.hsmnzaydn.gunluk_burc_android.horoscope.data.entities.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.base.Result

interface HoroscopeRepository{

    suspend fun getHoroscopes(): Result<List<HoroscopeResponse>>

}