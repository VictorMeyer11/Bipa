package com.bipa.main.domain.model

data class Node(
    val alias: String,
    val capacity: Double,
    val channels: Int,
    val locationName: String,
    val firstSeen: String,
    val publicKey: String,
    val updatedAt: String
)
