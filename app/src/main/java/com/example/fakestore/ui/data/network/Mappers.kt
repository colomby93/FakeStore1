package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.AuthLoginDto
import com.example.fakestore.ui.domain.model.AuthLogin

fun AuthLoginDto.toModel(): AuthLogin = AuthLogin(
    accessToken = accessToken,
    refreshToken = refreshToken
)