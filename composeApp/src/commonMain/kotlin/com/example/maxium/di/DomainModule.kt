package com.example.maxium.di

import com.example.domain.usecase.GetThemeUseCase
import com.example.domain.usecase.SetThemeUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetThemeUseCase> {
        GetThemeUseCase(get())
    }
    factory<SetThemeUseCase> {
        SetThemeUseCase(get())
    }
}