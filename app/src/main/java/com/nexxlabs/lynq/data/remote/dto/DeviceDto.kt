package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DeviceDto(
    @SerializedName("device_id") val deviceId: String,
    @SerializedName("user_id") val userId: String,
    val platform: String,
    @SerializedName("push_token") val pushToken: String? = null,
    @SerializedName("last_seen") val lastSeen: String? = null
)
