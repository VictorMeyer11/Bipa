package com.clansoft.main.domain.usecase

import javax.inject.Inject

class ConvertToBitcoin @Inject constructor() {
    operator fun invoke(valueInSat: Long) : Double = valueInSat / 100000000.toDouble()
}
