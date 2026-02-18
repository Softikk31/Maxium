package com.example.data.sources.local.room

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDao {
    @Query("INSERT OR REPLACE INTO settings(id, theme) VALUES (1, :theme)")
    suspend fun setTheme(theme: Int)

    @Query("SELECT theme FROM settings WHERE id = 1")
    fun getTheme(): Flow<Int?>
}