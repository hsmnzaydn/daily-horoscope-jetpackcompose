package com.hsmnzaydn.gunluk_burc_android.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HoroscopeRepository @Inject constructor(
    private val horoscopeRemoteDataSource: HoroscopeRemoteDataSource
) {

    suspend fun fetHoroscopes(): Flow<Result<List<HoroscopeResponse>>?> {
        return flow {
            emit(Result.loading())
            val result = horoscopeRemoteDataSource.getHoroscopes()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}