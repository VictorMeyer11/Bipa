package com.bipa.main.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.bipa.main.data.dto.NodeDto
import com.bipa.main.domain.model.Node
import javax.inject.Inject

class NodeMapper @Inject constructor(
    private val convertToBitcoinMapper: ConvertToBitcoinMapper,
    private val convertFromUnixMapper: ConvertFromUnixMapper
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun map(nodeDto: NodeDto): Node = nodeDto.run {
        val cityName = city?.ptBR ?: city?.en ?: ""
        val countryCode = country?.ptBR ?: country?.en ?: ""

        return Node(
            alias = alias,
            capacity = convertToBitcoinMapper.map(capacity) ?: 0.0,
            channels = channels,
            locationName = buildString {
                append(if (cityName.isNotEmpty()) "$cityName, " else "")
                append(countryCode)
            },
            firstSeen = convertFromUnixMapper.map(firstSeen) ?: HYPHEN,
            publicKey = publicKey,
            updatedAt = convertFromUnixMapper.map(updatedAt) ?: HYPHEN,
        )
    }

    companion object {
        private const val HYPHEN = "-"
    }
}
