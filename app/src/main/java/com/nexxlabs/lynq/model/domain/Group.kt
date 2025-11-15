package com.nexxlabs.lynq.model.domain

data class Group(
    val id: String,
    val name: String,
    val description: String? = null,
    val createdBy: String,
    val createdAt: String
)
