package com.nexxlabs.lynq.model.domain

data class GroupMember(
    val id: String,
    val groupId: String,
    val userId: String,
    val role: String = "member", // owner | admin | member
    val joinedAt: String
)