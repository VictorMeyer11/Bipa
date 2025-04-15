package com.clansoft.main.data.datasource

import com.clansoft.main.data.api.MainApi
import com.clansoft.main.data.dto.NodeDto
import com.clansoft.network.data.datasource.NetworkDataSource
import javax.inject.Inject

class MainDataSource @Inject constructor(
    private val api: MainApi,
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getNodeList(): Result<List<NodeDto>> = networkDataSource.call {
        api.getNodes()
    }
}
