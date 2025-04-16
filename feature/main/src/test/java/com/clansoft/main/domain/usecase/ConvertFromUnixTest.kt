package com.clansoft.main.domain.usecase

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import java.time.Instant

class ConvertFromUnixTest {
    private val convertFromUnix = ConvertFromUnix()

    @Test
    fun `should return January first, 1970 when 0 is provided`() {
        val unixTime = 0
        val formattedDateAndTime = convertFromUnix(unixTime)
        assertThat(formattedDateAndTime).isEqualTo("19:00 31/12/1969")
    }

    @Test
    fun `should return null when a negative number is provided`() {
        val unixTime = -1
        val formattedDateAndTime = convertFromUnix(unixTime)
        assertThat(formattedDateAndTime).isEqualTo(null)
    }

    @Test
    fun `should return null when a unix too big is provided` () {
        val currentTime = Instant.now().epochSecond.toInt()
        val oneDayInSeconds = 90000
        val formattedDateAndTime = convertFromUnix(currentTime + oneDayInSeconds)
        assertThat(formattedDateAndTime).isEqualTo(null)
    }
}
