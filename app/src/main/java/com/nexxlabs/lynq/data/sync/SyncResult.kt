package com.nexxlabs.lynq.data.sync

data class SyncResult(
    val opId: String,
    val status: String, // success | failed
    val serverId: String? = null,
    val errorCode: String? = null,
    val errorMessage: String? = null
)
