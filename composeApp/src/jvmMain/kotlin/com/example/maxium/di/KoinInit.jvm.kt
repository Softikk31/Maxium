package com.example.maxium.di

import com.example.data.sources.local.room.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

val jvmModule = module {
    single { getDatabaseBuilder() }
}

actual fun platformModule(): Module = jvmModule