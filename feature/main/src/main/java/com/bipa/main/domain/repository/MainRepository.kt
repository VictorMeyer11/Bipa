package com.bipa.main.domain.repository

import com.bipa.main.domain.model.Node

interface MainRepository {
    suspend fun getNodes(): Result<List<Node>>
}
