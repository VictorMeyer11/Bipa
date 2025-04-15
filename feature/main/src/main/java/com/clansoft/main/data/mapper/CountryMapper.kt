package com.clansoft.main.data.mapper

import com.clansoft.main.data.dto.CountryDto
import com.clansoft.main.domain.model.Country
import javax.inject.Inject

class CountryMapper @Inject constructor() {
    fun map(countryDto: CountryDto) : Country = Country(
        de = countryDto.de,
        en = countryDto.en,
        es = countryDto.es,
        fr = countryDto.fr,
        ja = countryDto.ja,
        ptBR = countryDto.ptBR,
        ru = countryDto.ru,
        zhCN = countryDto.zhCN
    )
}
