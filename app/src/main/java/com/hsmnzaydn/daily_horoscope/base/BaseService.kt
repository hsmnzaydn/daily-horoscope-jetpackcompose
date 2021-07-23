package com.hsmnzaydn.daily_horoscope.base

import android.util.Log
import retrofit2.Response
import java.lang.Error

open class BaseService {

    open suspend fun <T> getResponse(request: suspend () -> Response<T>): Result<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {

                Result.error("", Error())
            }
        } catch (e: Throwable) {
            Log.d("ErrorService",e.localizedMessage)
            Result.error("Unknown Error", null)
        }
    }
}