package com.bipa.main.data.mapper

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test
import java.time.Instant

class ConvertFromUnixMapperTest {
    private val convertFromUnix = ConvertFromUnixMapper()

    @Test
    fun `should return January first, 1970 when 0 is provided`() {
        val unixTime = 0
        val formattedDateAndTime = convertFromUnix.map(unixTime)
        assertThat(formattedDateAndTime).isEqualTo("19:00 31/12/1969")
    }

    @Test
    fun `should return null when a negative number is provided`() {
        val unixTime = -1
        val formattedDateAndTime = convertFromUnix.map(unixTime)
        assertThat(formattedDateAndTime).isNull()
    }

    @Test
    fun `should return null when a unix too big is provided` () {
        val currentTime = Instant.now().epochSecond.toInt()
        val oneDayInSeconds = 90000
        val formattedDateAndTime = convertFromUnix.map(currentTime + oneDayInSeconds)
        assertThat(formattedDateAndTime).isNull()
    }
}
