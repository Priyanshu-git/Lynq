package com.nexxlabs.lynq.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nexxlabs.lynq.core.UIState
import com.nexxlabs.lynq.viewmodel.DashboardViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Preview
@Composable
fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel()) {
    val state = viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Top metrics row (simple static placeholders for now)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Total Lists\n12")
            Text("Shared\n8")
            Text("Active\n5")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Recently Updated")

        Spacer(modifier = Modifier.height(8.dp))

        when (val s = state.value) {
            is UIState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is UIState.Error -> {
                Column {
                    Text(text = s.message ?: "Unknown error")
                    Button(onClick = { viewModel.refresh() }) { Text("Retry") }
                }
            }
            is UIState.Success -> {
                val lists = s.data ?: emptyList()
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(lists) { item ->
                        ListCard(item = item)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.refresh() }, modifier = Modifier.fillMaxWidth()) { Text("Refresh") }
    }
}