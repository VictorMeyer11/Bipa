package com.bipa.main.data.mapper

import com.bipa.main.data.dto.CityDto
import com.bipa.main.domain.model.City
import javax.inject.Inject

class CityMapper @Inject constructor() {
    fun map(cityDto: CityDto) : City = City(
        cityName = cityDto.ptBR ?: cityDto.en ?: ""
    )
}
