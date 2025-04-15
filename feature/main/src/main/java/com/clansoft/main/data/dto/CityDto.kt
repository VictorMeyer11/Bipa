package com.clansoft.main.data.dto

import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("de") val de: String?,
    @SerializedName("en") val en: String?,
    @SerializedName("es") val es: String?,
    @SerializedName("fr") val fr: String?,
    @SerializedName("ja") val ja: String?,
    @SerializedName("pt-BR") val ptBR: String?,
    @SerializedName("ru") val ru: String?
)
