package com.clansoft.main.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

class ConvertFromUnix @Inject constructor() {
    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(unix: Int): String? {
        val zoneId = ZoneId.of("America/New_York")
        val instant = Instant.ofEpochSecond(unix.toLong())

        if (unix < 0) {
            return null
        }

        val currentTime = Instant.now().epochSecond
        val oneDayInSeconds = 86400L
        if (unix > currentTime + oneDayInSeconds) {
            return null
        }

        val formatter = DateTimeFormatter.ofPattern(
            "HH:mm dd/MM/yyyy",
           Locale.getDefault()
        )

        return instant.atZone(zoneId).format(formatter)
    }
}
