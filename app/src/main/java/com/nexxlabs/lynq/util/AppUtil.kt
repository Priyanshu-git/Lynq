package com.nexxlabs.lynq.util

import com.nexxlabs.lynq.core.ListCategory

fun getCategoryFromLabel(label: String): ListCategory? {
    return when (label.trim().lowercase()) {
        ListCategory.Shopping.label.lowercase() -> ListCategory.Shopping
        ListCategory.General.label.lowercase() -> ListCategory.General
        ListCategory.Trip.label.lowercase() -> ListCategory.Trip
        ListCategory.Project.label.lowercase() -> ListCategory.Project
        else -> null
    }
}