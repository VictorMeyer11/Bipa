package com.bipa.main.data.datasource

import com.bipa.main.data.api.MainApi
import com.bipa.main.data.dto.NodeDto
import com.bipa.network.data.datasource.NetworkDataSource
import javax.inject.Inject

class MainDataSource @Inject constructor(
    private val api: MainApi,
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getNodeList(): Result<List<NodeDto>> = networkDataSource.call {
        api.getNodes()
    }
}
