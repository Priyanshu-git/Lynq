package com.nexxlabs.lynq.model.domain

data class ListModel(
    val id: String,
    val title: String,
    val description: String? = null,
    val type: String, // e.g. "grocery" | "general"
    val createdBy: String,
    val groupId: String? = null, // null for personal lists
    val createdAt: String,
    val updatedAt: String,
    val pendingCount: Int = 0 // UI helper
)