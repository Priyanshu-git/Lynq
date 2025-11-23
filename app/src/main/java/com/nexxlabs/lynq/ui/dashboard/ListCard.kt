package com.nexxlabs.lynq.ui.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexxlabs.lynq.model.domain.ListModel
import com.nexxlabs.lynq.util.getAccentCategoryColor
import com.nexxlabs.lynq.util.getCategoryFromLabel
import com.nexxlabs.lynq.util.getIconByCategory
import com.nexxlabs.lynq.util.getPrimaryCategoryColor

private val temp = ListModel(
    "list_weekly_groceries",
    "Weekly Groceries",
    "Shopping for this week",
    "shopping",
    "user_a",
    "group_1",
    null,
    null,
    pendingCount = 3
)

@Preview
@Composable
fun ListCard(item: ListModel = temp, onClick: () -> Unit = {}) {
    val listCategory = getCategoryFromLabel(item.type)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(4.dp), clip = false)
            .clickable { onClick() },
        shape = RoundedCornerShape(4.dp),
    ) {
        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(12.dp))

            // Image
            Box(
                modifier = Modifier
                    .background(
                        getAccentCategoryColor(listCategory),
                        shape = RoundedCornerShape(100)
                    )
                    .size(48.dp)
                    .border(
                        width = 1.dp,
                        color = getPrimaryCategoryColor(listCategory),
                        shape = RoundedCornerShape(100)
                    )
                    .padding(14.dp)
            ) {
                Image(
                    painter = painterResource(id = getIconByCategory(listCategory)),
                    contentDescription = "list image",
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    item.description ?: "Last updated just now",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
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