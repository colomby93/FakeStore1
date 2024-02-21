package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.AuthLoginDto
import com.example.fakestore.ui.data.network.model.CategoryDto
import com.example.fakestore.ui.data.network.model.LoginDto
import com.example.fakestore.ui.data.network.model.ProductDto
import com.example.fakestore.ui.data.network.model.ProductForCategoryDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FakeStoreAPIService {
    @POST("auth/login/")
    suspend fun login(@Body loginDto: LoginDto): Response<AuthLoginDto>

    @GET("categories")
    suspend fun getCategories(): Response<CategoryDto>

    @GET("products")
    suspend fun getProductsForCategory(@Query("categoryId") categoryId: String): Response<ProductForCategoryDto>

    @GET("products/{productId}")
    suspend fun getProductForId(@Path("productId") productId: String): Response<ProductDto>

    @GET("products")
    suspend fun getAllProducts(): Response<List<ProductDto>>

}