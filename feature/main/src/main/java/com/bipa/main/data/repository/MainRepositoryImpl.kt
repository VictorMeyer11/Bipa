package com.bipa.main.data.repository

import com.bipa.main.data.datasource.MainDataSource
import com.bipa.main.data.mapper.NodeMapper
import com.bipa.main.domain.model.Node
import com.bipa.main.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val dataSource: MainDataSource,
    private val nodeMapper: NodeMapper
) : MainRepository {
    override suspend fun getNodes(): Result<List<Node>> = Result.run {
        dataSource.getNodeList().fold(
            onSuccess = {
                success(it.map { nodeDto ->
                    nodeMapper.map(nodeDto)
                })
            },
            onFailure = ::failure
        )
    }
}


