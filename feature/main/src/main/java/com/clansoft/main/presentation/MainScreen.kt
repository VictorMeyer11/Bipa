package com.clansoft.main.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.clansoft.main.R
import com.clansoft.main.presentation.component.NodeCard
import com.clansoft.ui.theme.Blue800

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold  { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Blue800)
                .padding(padding)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.check_out_the_100_best_connected_nodes_of_the_lightning_network),
                fontSize = 24.sp,
                color = Color.White
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                items(state.nodeList) { node ->
                    NodeCard(
                        viewModel = viewModel,
                        node = node
                    )
                }
            }
        }
    }
}
