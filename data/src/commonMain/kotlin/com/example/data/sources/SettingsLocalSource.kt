package com.example.data.sources

import kotlinx.coroutines.flow.Flow

interface SettingsLocalSource {
    suspend fun setTheme(theme: Int)
    fun getTheme(): Flow<Int>
}