package com.bipa.network.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor() : NetworkDataSource {
    override suspend fun <T> call(
        onError: ((errorCode: Int) -> String?)?,
        callback: suspend () -> Response<T>,
    ): Result<T> = withContext(Dispatchers.IO) {
        try {
            val result = callback()
            if (result.isSuccessful) {
                result.body()?.let {
                    Result.success(it)
                } ?: getDefaultError()
            } else {
                Result.failure(
                    exception = Throwable(onError?.invoke(result.code()) ?: "Failed to fetch data")
                )
            }
        } catch (e: Exception) {
            getDefaultError()
        }
    }

    private fun <T> getDefaultError(): Result<T> = Result.failure(
        Throwable("Something went wrong")
    )
}
