package com.example.maxium

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class PlatformDTO {
    Android, Desktop
}

interface Platform {
    val name: PlatformDTO
}

expect fun getPlatform(): Platform

enum class Languages {
    RU, EN
}

val languagesMap = mapOf(Languages.RU to "ru", Languages.EN to "en")

expect fun selectLanguage(selectionLocale: Languages)

expect fun getLanguage(): Languages

@Composable
expect fun getContext(): Any?

object AppLocale {
    private val _locale = MutableStateFlow<String?>(null)
    val locale = _locale.asStateFlow()

    fun set(locale: String?) {
        _locale.value = locale
    }
}