package com.hsmnzaydn.gunluk_burc_android.horoscope.domain.usecase

import com.hsmnzaydn.gunluk_burc_android.base.Result
import com.hsmnzaydn.gunluk_burc_android.horoscope.data.entities.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.repository.HoroscopeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import toHoroscope
import javax.inject.Inject

class HoroscopeUseCase @Inject constructor(private val horoscopeRepository: HoroscopeRepository){

    suspend fun fetHoroscopes(): Flow<List<Horoscope>?> {
        return flow {
            emit(horoscopeRepository.getHoroscopes().data?.map {
                it.toHoroscope()
            })
        }.flowOn(Dispatchers.IO)
    }
}