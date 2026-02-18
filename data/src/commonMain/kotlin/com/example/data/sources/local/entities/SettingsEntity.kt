package com.example.data.sources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("settings")
data class SettingsEntity(
    @PrimaryKey
    val id: Long = 1,
    @ColumnInfo("theme", defaultValue = "1")
    val theme: Int = 1
)