package com.clansoft.main.domain.usecase

import javax.inject.Inject

class ConvertToBitcoin @Inject constructor() {
    operator fun invoke(valueInSat: Long) : Double? {
        if(valueInSat < 0) return null

        return valueInSat / 100000000.toDouble()
    }
}
