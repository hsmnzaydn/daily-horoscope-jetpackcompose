package com.hsmnzaydn.daily_horoscope.horoscope.domain.repository

import com.hsmnzaydn.daily_horoscope.horoscope.data.entities.HoroscopeResponse
import com.hsmnzaydn.daily_horoscope.base.Result

interface HoroscopeRepository {

    suspend fun getHoroscopes(): Result<List<HoroscopeResponse>>

    suspend fun getHoroscopeDetail(id: String): Result<HoroscopeResponse>

}