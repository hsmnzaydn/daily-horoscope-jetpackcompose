package com.hsmnzaydn.gunluk_burc_android.data

import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Error
import javax.inject.Inject

class HoroscopeRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    suspend fun getHoroscopes(): Result<List<HoroscopeResponse>> {
        val horoscopeServices = retrofit.create(HoroscopeApi::class.java);
        return getResponse(
            request = { horoscopeServices.getHoroscopes(1626739504000) },
            defaultErrorMessage = "Error fetching Movie list")

    }


    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {

                Result.error("", Error())
            }
        } catch (e: Throwable) {
            Result.error("Unknown Error", null)
        }
    }
}