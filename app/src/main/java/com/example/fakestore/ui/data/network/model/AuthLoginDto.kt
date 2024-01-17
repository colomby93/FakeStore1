package com.example.fakestore.ui.data.network.model


import com.google.gson.annotations.SerializedName

data class AuthLoginDto(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String
)