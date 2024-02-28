package com.example.fakestore.ui.data.preference

import android.content.Context
import android.content.SharedPreferences

class CommonPreferences(context: Context) : Preferences {

    companion object {
        private const val SHARED_PREFS = "sharedPrefs"
        private const val TOKEN_KEY = "TOKEN_KEY"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    override fun hasToken(): Boolean = sharedPreferences.contains(TOKEN_KEY)
    override fun setToken(token: String) = setString(TOKEN_KEY, token)
    override fun getToken(): String = getString(TOKEN_KEY)

    private fun setString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    private fun getString(key: String): String = sharedPreferences.getString(key, "") ?: ""

}