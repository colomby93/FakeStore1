package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.AuthLoginDto
import com.example.fakestore.ui.data.network.model.LoginDto
import com.example.fakestore.ui.data.network.model.ProductForCategoryDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FakeStoreAPIService {
    @POST("auth/login/")
    suspend fun login(@Body loginDto: LoginDto): Response<AuthLoginDto>

    @GET("products/?categoryId={productId}")
    suspend fun getProductsForCategory(@Path("productId") productId: String): Response<ProductForCategoryDto>


}