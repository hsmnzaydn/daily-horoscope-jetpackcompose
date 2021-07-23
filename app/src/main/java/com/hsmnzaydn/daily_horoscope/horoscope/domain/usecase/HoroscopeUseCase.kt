package com.hsmnzaydn.daily_horoscope.horoscope.domain.usecase

import com.hsmnzaydn.daily_horoscope.base.Result
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.daily_horoscope.horoscope.domain.repository.HoroscopeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import toHoroscope
import javax.inject.Inject

class HoroscopeUseCase @Inject constructor(private val horoscopeRepository: HoroscopeRepository){

    suspend fun fetHoroscopes(): Flow<Result<List<Horoscope>>> {
        return flow {
            var result = horoscopeRepository.getHoroscopes()
                emit(Result.success(result.data?.map {
                    it.toHoroscope()
                }))
        }.flowOn(Dispatchers.IO)
    }



    fun getDescriptionDetail(
        id: String
    ): Flow<Result<Horoscope>> {
        return flow {
            emit(Result.success(horoscopeRepository.getHoroscopeDetail(id).data?.toHoroscope()))
        }.flowOn(Dispatchers.IO)

    }
}