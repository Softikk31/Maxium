package com.example.maxium

import androidx.compose.runtime.Composable

enum class PlatformDTO {
    Android,
    Desktop
}

interface Platform {
    val name: PlatformDTO
}

expect fun getPlatform(): Platform

expect fun openLanguageSettings(context: Any)

@Composable
expect fun getContext(): Any?