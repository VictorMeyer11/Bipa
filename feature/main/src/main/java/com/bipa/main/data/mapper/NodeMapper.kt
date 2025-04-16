package com.bipa.main.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.bipa.main.data.dto.NodeDto
import com.bipa.main.domain.model.Node
import javax.inject.Inject

class NodeMapper @Inject constructor(
    private val cityMapper: CityMapper,
    private val countryMapper: CountryMapper,
    private val convertToBitcoinMapper: ConvertToBitcoinMapper,
    private val convertFromUnixMapper: ConvertFromUnixMapper
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun map(nodeDto: NodeDto): Node {
        val cityName = nodeDto.city?.let(cityMapper::map)?.cityName ?: ""
        val countryCode = nodeDto.country?.let(countryMapper::map)?.countryCode ?: ""

        return Node(
            alias = nodeDto.alias,
            capacity = convertToBitcoinMapper.map(nodeDto.capacity) ?: 0.0,
            channels = nodeDto.channels,
            locationName = buildString {
                append(if (cityName.isNotEmpty()) "$cityName, " else "")
                append(countryCode.ifEmpty { "" })
            },
            firstSeen = convertFromUnixMapper.map(nodeDto.firstSeen) ?: "-",
            publicKey = nodeDto.publicKey,
            updatedAt = convertFromUnixMapper.map(nodeDto.updatedAt) ?: "-"
        )
    }
}
