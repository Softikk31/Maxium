package com.example.data.sources.local

import com.example.data.sources.SettingsLocalSource
import com.example.data.sources.local.room.SettingsDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsLocalSourceImpl(private val dao: SettingsDao) : SettingsLocalSource {
    override suspend fun setTheme(theme: Int) = dao.setTheme(theme)
    override fun getTheme(): Flow<Int> {
        return dao.getTheme().map {
            it ?: 1
        }
    }
}