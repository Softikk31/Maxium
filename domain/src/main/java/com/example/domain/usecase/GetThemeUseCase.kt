package com.example.domain.usecase

import com.example.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

class GetThemeUseCase(private val repository: SettingsRepository) {
    operator fun invoke(): Flow<Int> = repository.getTheme()
}