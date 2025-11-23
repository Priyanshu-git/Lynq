package com.nexxlabs.lynq.ui.dashboard

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nexxlabs.lynq.core.UIState
import com.nexxlabs.lynq.ui.components.DashBoardTile
import com.nexxlabs.lynq.viewmodel.DashboardViewModel


@Preview
@Composable
fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel()) {
    val state = viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top metrics row (simple static placeholders for now)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            DashBoardTile("Total Lists", "12")
            DashBoardTile("Shared", "8")
            DashBoardTile("Active", "5")
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Recently Updated", fontSize = 16.sp)


            Text(
                "View All  >",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable(
                    true,
                    onClick = {
                        Toast.makeText(context, "View All Clicked", Toast.LENGTH_SHORT).show()
                    }
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        when (val s = state.value) {
            is UIState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background)
                        .graphicsLayer(clip = false)
                ) {
                    items(lists) { item ->
                        ListCard(item = item)
                        Spacer(Modifier.height(6.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { viewModel.refresh() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Refresh") }
    }
}