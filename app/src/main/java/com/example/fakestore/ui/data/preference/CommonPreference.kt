package com.example.fakestore.ui.data.preference

import android.content.Context

class CommonPreference(context: Context) : Preference {

    companion object {
        private const val SHARED_PREFS = "sharedPrefs"
    }

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    override suspend fun token(token: String) {
        val editor = sharedPreferences.edit()
        editor.apply() {
            putString(SHARED_PREFS, token)
        }.apply()
    }

}