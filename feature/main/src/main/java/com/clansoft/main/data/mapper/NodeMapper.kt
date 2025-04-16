package com.clansoft.main.data.mapper

import com.clansoft.main.data.dto.NodeDto
import com.clansoft.main.domain.model.Node
import javax.inject.Inject

class NodeMapper @Inject constructor(
    private val cityMapper: CityMapper,
    private val countryMapper: CountryMapper
) {
    fun map(nodeDto: NodeDto): Node = Node(
        alias = nodeDto.alias,
        capacity = nodeDto.capacity,
        channels = nodeDto.channels,
        city = nodeDto.city?.let(cityMapper::map),
        country = nodeDto.country?.let(countryMapper::map),
        firstSeen = nodeDto.firstSeen,
        publicKey = nodeDto.publicKey,
        updatedAt = nodeDto.updatedAt
    )
}
