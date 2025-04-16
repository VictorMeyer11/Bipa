package com.clansoft.main.domain.usecase

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ConvertToBitcoinTest {
    private val convertToBitcoin = ConvertToBitcoin()

    @Test
    fun `should return 0 when given number is 0`() {
        val numberOfSats = 0L
        val convertedValue = convertToBitcoin(numberOfSats)
        assertThat(convertedValue).isEqualTo(0.0)
    }

    @Test
    fun `should return 1 when given number is 100000000`() {
        val numberOfSats = 100000000L
        val convertedValue = convertToBitcoin(numberOfSats)
        assertThat(convertedValue).isEqualTo(1.0)
    }

    @Test
    fun `should return 0,00000465 when given number is 100000000`() {
        val numberOfSats = 465L
        val convertedValue = convertToBitcoin(numberOfSats)
        assertThat(convertedValue).isEqualTo(0.00000465)
    }

    @Test
    fun `should return null when given number is negative`() {
        val numberOfSats = -1L
        val convertedValue = convertToBitcoin(numberOfSats)
        assertThat(convertedValue).isEqualTo(null)
    }
}
