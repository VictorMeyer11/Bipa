package com.bipa.main.presentation.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clansoft.main.R
import com.bipa.main.domain.model.Node
import com.bipa.ui.theme.Blue700


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NodeCard(
    node: Node,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Blue700,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append("${node.alias}: ")
                withStyle(
                    style = SpanStyle(fontSize = 10.sp, fontStyle = FontStyle.Italic)
                ) {
                    append(node.publicKey)
                }
            },
            color = Color.White,
            fontSize = 14.sp
        )
        Text(
            text = "${node.capacity} BTC",
            color = Color.White,
            fontSize = 12.sp
        )
        Text(
            text = stringResource(R.string.number_of_channels, node.channels),
            color = Color.White,
            fontSize = 12.sp
        )
        Text(
            text = node.locationName,
            color = Color.White,
            fontSize = 12.sp
        )
        Text(
            text = stringResource(
                R.string.first_seen_at,
                node.firstSeen
            ),
            color = Color.White,
            fontSize = 12.sp
        )
        Text(
            text = stringResource(
                R.string.updated_at,
                node.updatedAt
            ),
            color = Color.White,
            fontSize = 12.sp
        )
    }
}
