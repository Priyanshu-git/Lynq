package com.nexxlabs.lynq.core

sealed class ListCategory(val label: String) {
    object Shopping: ListCategory("Shopping")
    object General: ListCategory("General")
    object Trip: ListCategory("Trip")
    object Project: ListCategory("Project")
}