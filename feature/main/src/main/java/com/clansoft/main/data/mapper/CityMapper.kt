package com.clansoft.main.data.mapper

import com.clansoft.main.data.dto.CityDto
import com.clansoft.main.domain.model.City
import javax.inject.Inject

class CityMapper @Inject constructor() {
    fun map(cityDto: CityDto) : City = City(
        de = cityDto.de,
        en = cityDto.en,
        es = cityDto.es,
        fr = cityDto.fr,
        ja = cityDto.ja,
        ptBR = cityDto.ptBR,
        ru = cityDto.ru
    )
}
