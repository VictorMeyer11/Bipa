package com.bipa.main.data.mapper

import javax.inject.Inject

class ConvertToBitcoinMapper @Inject constructor() {
    fun map(valueInSat: Long): Double? = valueInSat.takeIf {
        it >= 0
    }?.div(DENOMINATOR.toDouble())
}

private const val DENOMINATOR = 100_000_000
