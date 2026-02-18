package com.example.domain.usecase

import com.example.domain.repository.SettingsRepository

class SetThemeUseCase(private val repository: SettingsRepository) {
    suspend operator fun invoke(theme: Int) = repository.setTheme(theme)
}