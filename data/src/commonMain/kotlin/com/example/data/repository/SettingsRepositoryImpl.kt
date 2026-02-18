package com.example.data.repository

import com.example.data.sources.SettingsLocalSource
import com.example.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(private val localeSource: SettingsLocalSource) : SettingsRepository {
    override suspend fun setTheme(theme: Int) = localeSource.setTheme(theme)
    override fun getTheme(): Flow<Int> = localeSource.getTheme()
}