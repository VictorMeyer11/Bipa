package com.bipa.main.data.mapper

import com.bipa.main.data.dto.CountryDto
import com.bipa.main.domain.model.Country
import javax.inject.Inject

class CountryMapper @Inject constructor() {
    fun map(countryDto: CountryDto) : Country = Country(
        countryCode = countryDto.ptBR ?: countryDto.en ?: ""
    )
}
