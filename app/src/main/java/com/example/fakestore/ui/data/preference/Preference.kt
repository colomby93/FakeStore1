package com.example.fakestore.ui.data.preference

interface Preference{
    suspend fun token(token: String)
}