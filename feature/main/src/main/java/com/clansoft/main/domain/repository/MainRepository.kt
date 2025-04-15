package com.clansoft.main.domain.repository

import com.clansoft.main.domain.model.Node

interface MainRepository {
    suspend fun getNodes(): Result<List<Node>>
}
