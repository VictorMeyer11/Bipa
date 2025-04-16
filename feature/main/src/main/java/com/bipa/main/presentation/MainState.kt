package com.bipa.main.presentation

import com.bipa.main.domain.model.Node

data class MainState(
    val nodeList: List<Node>,
    val isRefreshing: Boolean,
    val isLoading: Boolean
)
