package com.nexxlabs.lynq.model.domain


data class InviteModel(
    val id: String,
    val groupId: String,
    val invitedBy: String,
    val invitedEmail: String? = null,
    val status: String, // pending | accepted | declined
    val createdAt: String
)
