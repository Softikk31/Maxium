package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun setTheme(theme: Int)
    fun getTheme(): Flow<Int>
}