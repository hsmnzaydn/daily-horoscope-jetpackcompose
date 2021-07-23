package com.hsmnzaydn.gunluk_burc_android.base

import com.hsmnzaydn.gunluk_burc_android.base.Result
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
            Result.error("Unknown Error", null)
        }
    }
}