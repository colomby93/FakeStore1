package com.example.fakestore.ui.domain.model

data class UserProfile(
    val avatar: String,
    val email: String,
    val id: Int,
    val name: String,
    val password: String,
    val role: String
)