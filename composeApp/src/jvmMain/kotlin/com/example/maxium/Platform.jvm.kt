package com.example.maxium

import androidx.compose.runtime.Composable

class JVMPlatform: Platform {
    override val name: PlatformDTO = PlatformDTO.Desktop
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun openLanguageSettings(context: Any) {
}

@Composable
actual fun getContext(): Any? = null