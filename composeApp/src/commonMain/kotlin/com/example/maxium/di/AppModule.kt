package com.example.maxium.di

import com.example.maxium.ui.main.SettingsViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::SettingsViewModel)
}