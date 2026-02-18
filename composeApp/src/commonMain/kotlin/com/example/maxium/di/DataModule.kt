package com.example.maxium.di

import com.example.data.repository.SettingsRepositoryImpl
import com.example.data.sources.SettingsLocalSource
import com.example.data.sources.local.SettingsLocalSourceImpl
import com.example.data.sources.local.room.AppDatabase
import com.example.data.sources.local.room.SettingsDao
import com.example.data.sources.local.room.getRoomDatabase
import com.example.domain.repository.SettingsRepository
import org.koin.dsl.module

val dataModule = module {
    single<AppDatabase> {
        getRoomDatabase(get())
    }
    single<SettingsDao> {
        get<AppDatabase>().getDao()
    }
    single<SettingsLocalSource> {
        SettingsLocalSourceImpl(get())
    }
    single<SettingsRepository> {
        SettingsRepositoryImpl(get())
    }
}