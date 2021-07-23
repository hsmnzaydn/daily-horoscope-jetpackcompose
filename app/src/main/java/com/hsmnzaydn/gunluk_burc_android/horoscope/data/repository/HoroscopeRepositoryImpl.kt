package com.hsmnzaydn.gunluk_burc_android.horoscope.data.repository

import com.hsmnzaydn.gunluk_burc_android.base.BaseService
import com.hsmnzaydn.gunluk_burc_android.horoscope.data.entities.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.base.Result
import com.hsmnzaydn.gunluk_burc_android.horoscope.data.api.HoroscopeServices
import retrofit2.Retrofit
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.repository.HoroscopeRepository

class HoroscopeRepositoryImpl(private val retrofit: Retrofit) : BaseService(), HoroscopeRepository {

    fun getHoroscopeServices(): HoroscopeServices = retrofit.create(HoroscopeServices::class.java)

    override suspend fun getHoroscopes(): Result<List<HoroscopeResponse>> {
        return getResponse(
            request = { getHoroscopeServices().getHoroscopes(1626739504000) })
    }

    override suspend fun getHoroscopeDetail(id: String): Result<HoroscopeResponse> {
        return getResponse (
            request = {getHoroscopeServices().getHoroscopeDetail(id)}
        )
    }


}