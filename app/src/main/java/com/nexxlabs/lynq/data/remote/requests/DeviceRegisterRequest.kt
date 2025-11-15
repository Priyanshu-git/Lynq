package com.nexxlabs.lynq.data.remote.requests

import com.google.gson.annotations.SerializedName

data class DeviceRegisterRequest(
    @SerializedName("device_id") val deviceId: String,
    val platform: String,
    @SerializedName("push_token") val pushToken: String? = null
)
