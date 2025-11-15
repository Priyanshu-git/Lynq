package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AuthResponseDto(
    val user: UserDto,
    @SerializedName("jwt_token") val jwtToken: String,
    @SerializedName("jwt_expires_at") val jwtExpiresAt: String
)
