package com.clansoft.main.presentation

import com.clansoft.main.domain.model.Node

data class MainState(
    val nodeList: List<Node>,
    val isRefreshing: Boolean,
    val isLoading: Boolean
)
