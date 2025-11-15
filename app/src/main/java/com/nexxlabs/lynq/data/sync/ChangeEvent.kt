package com.nexxlabs.lynq.data.sync

data class ChangeEvent(
    val eventId: String,
    val entity: String,
    val action: String,
    val entityId: String,
    val payloadJson: String,
    val createdAt: Long
)
