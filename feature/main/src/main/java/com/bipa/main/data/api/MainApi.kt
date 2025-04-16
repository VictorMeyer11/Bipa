package com.bipa.main.data.api

import com.bipa.main.data.dto.NodeDto
import retrofit2.Response
import retrofit2.http.GET

interface MainApi {
    @GET("lightning/nodes/rankings/connectivity")
    suspend fun getNodes() : Response<List<NodeDto>>
}
