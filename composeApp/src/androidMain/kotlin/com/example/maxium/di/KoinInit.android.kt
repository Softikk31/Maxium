package com.example.maxium.di

import android.content.Context
import com.example.data.sources.local.room.getDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val androidModule = module {
    single { getDatabaseBuilder(androidContext()) }
}

actual fun platformModule(): Module = androidModule

fun initKoinAndroid(context: Context) {
    if (GlobalContext.getOrNull() == null) {
        startKoin {
            androidContext(context)
            modules(
                commonModules
            )
        }
    }
}