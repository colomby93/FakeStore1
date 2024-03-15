package com.example.fakestore.ui.data.preference

interface Preferences {
    fun hasToken(): Boolean
    fun setToken(token: String)
    fun getToken(): String
}