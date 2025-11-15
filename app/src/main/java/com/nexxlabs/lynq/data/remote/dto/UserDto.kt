package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("user_id") val userId: String,
    val username: String,
    val email: String,
    @SerializedName("profile_picture") val profilePicture: String? = null
)
