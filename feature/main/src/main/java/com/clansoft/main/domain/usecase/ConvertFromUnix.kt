package com.clansoft.main.domain.usecase

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class ConvertFromUnix @Inject constructor() {
    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(context: Context, unix: Int): String? {
        val zoneId = ZoneId.systemDefault()
        val instant = Instant.ofEpochSecond(unix.toLong())

        val formatter = DateTimeFormatter.ofPattern(
            "HH:mm dd/MM/yyyy",
            context.resources.configuration.locales[0]
        )

        return instant.atZone(zoneId).format(formatter)
    }
}
