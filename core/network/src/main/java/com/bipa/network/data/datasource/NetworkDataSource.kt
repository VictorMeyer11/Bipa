package com.bipa.network.data.datasource

import retrofit2.Response

interface NetworkDataSource {
    suspend fun <T> call(
        onError: ((errorCode: Int) -> String?)? = null,
        callback: suspend () -> Response<T>,
    ): Result<T>
}
