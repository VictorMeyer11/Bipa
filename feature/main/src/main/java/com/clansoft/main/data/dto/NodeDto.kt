package com.clansoft.main.data.dto

import com.google.gson.annotations.SerializedName

data class NodeDto(
    @SerializedName("alias") val alias: String,
    @SerializedName("capacity") val capacity: Long,
    @SerializedName("channels") val channels: Int,
    @SerializedName("city") val city: CityDto?,
    @SerializedName("country") val country: CountryDto?,
    @SerializedName("firstSeen") val firstSeen: Int,
    @SerializedName("publicKey") val publicKey: String,
    @SerializedName("updatedAt") val updatedAt: Int
)
