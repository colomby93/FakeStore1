package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.AuthLoginDto
import com.example.fakestore.ui.data.network.model.LoginDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FakeStoreAPIService {
    @POST("auth/login/")
    suspend fun login(@Body loginDto: LoginDto): Response<AuthLoginDto>

}