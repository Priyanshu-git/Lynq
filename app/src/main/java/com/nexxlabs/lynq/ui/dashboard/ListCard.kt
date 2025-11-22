package com.nexxlabs.lynq.ui.dashboard


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.nexxlabs.lynq.model.domain.ListModel

// Use the uploaded file as sample image URL (file:///...).
private const val SAMPLE_IMAGE_URL = "file:///mnt/data/8e8afd3f-4e25-4ea3-ab94-9bb98e62f525.jpg"

@Composable
fun ListCard(item: ListModel, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
//        elevation = CardElevation()
    ) {
        Row(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Left accent bar
            val accentColor = when (item.type) {
                "grocery" -> Color(0xFF8EB69B)
                "general" -> Color(0xFF235347)
                else -> Color(0xFF163832)
            }
            Box(
                modifier = Modifier
                    .size(width = 6.dp, height = 64.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(accentColor)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Image (using Coil to load file:// path)
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(SAMPLE_IMAGE_URL)
                    .crossfade(true)
                    .build()
            )
            androidx.compose.foundation.Image(
                painter = painter,
                contentDescription = "list image",
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(item.description ?: "Last updated just now", fontSize = 12.sp, color = Color.Gray)
            }

            // pending count bubble
            Badge(
                modifier = Modifier.align(Alignment.Top)
            ) {
                Text(item.pendingCount.toString(), fontSize = 12.sp)
            }
        }
    }
}