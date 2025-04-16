package com.bipa.main.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject
import kotlin.time.Duration.Companion.days

class ConvertFromUnixMapper @Inject constructor() {
    @RequiresApi(Build.VERSION_CODES.O)
    fun map(unix: Int): String? {
        if (unix < 0) { return null }

        val zoneId = ZoneId.of(ZONE_ID)
        val instant = Instant.ofEpochSecond(unix.toLong())

        val currentTime = Instant.now().epochSecond
        val oneDayInSeconds = 1.days.inWholeSeconds
        if (unix > currentTime + oneDayInSeconds) {
            return null
        }

        val formatter = DateTimeFormatter.ofPattern(
            DATE_PATTERN,
            Locale.getDefault()
        )

        return instant.atZone(zoneId).format(formatter)
    }
}

private const val ZONE_ID = "America/New_York"
private const val DATE_PATTERN = "HH:mm dd/MM/yyyy"
