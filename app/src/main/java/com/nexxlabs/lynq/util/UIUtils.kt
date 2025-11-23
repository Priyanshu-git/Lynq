package com.nexxlabs.lynq.util

import androidx.compose.ui.graphics.Color
import com.nexxlabs.lynq.R
import com.nexxlabs.lynq.core.ListCategory

// Grocery (Green)
val ShoppingPrimary = Color(0xFF1B7F3C)
val ShoppingAccent = Color(0xFFDBFCE7)

// Trip (Blue)
val TripPrimary = Color(0xFF3B82F6)
val TripAccent = Color(0xFFDBEAFE)

// Project (Purple)
val ProjectPrimary = Color(0xFFA855F7)
val ProjectAccent = Color(0xFFF3E8FF)

// T0do (Orange)
val TodoPrimary = Color(0xFFE45A19)
val TodoAccent = Color(0xFFFEE8D5)

val DefaultPrimary = Color(0xFFFFEB3B)
val DefaultAccent = Color(0xFFFDF8C6)



fun getPrimaryCategoryColor(category: ListCategory?): Color {
    return when (category) {
        ListCategory.Shopping -> ShoppingPrimary
        ListCategory.General -> TodoPrimary
        ListCategory.Project -> ProjectPrimary
        ListCategory.Trip -> TripPrimary
        else -> DefaultPrimary
    }
}

fun getAccentCategoryColor(category: ListCategory?): Color {
    return when (category) {
        is ListCategory.Shopping -> ShoppingAccent
        is ListCategory.General -> TodoAccent
        is ListCategory.Project -> ProjectAccent
        is ListCategory.Trip -> TripAccent
        else -> DefaultAccent
    }
}


fun getIconByCategory(category: ListCategory?): Int {
    return when (category) {
        is ListCategory.Shopping -> R.drawable.shopping_cart
        is ListCategory.General -> R.drawable.square_check_big
        is ListCategory.Project -> R.drawable.briefcase
        is ListCategory.Trip -> R.drawable.map_pin
        else -> R.drawable.clipboard_list
    }
}