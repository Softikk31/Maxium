package com.example.maxium.di

import org.koin.core.module.Module

expect fun platformModule(): Module

val commonModules = listOf(domainModule, dataModule, platformModule(), appModule)