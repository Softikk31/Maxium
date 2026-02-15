package com.example.maxium

import androidx.compose.runtime.Composable
import java.util.Locale

class JVMPlatform : Platform {
    override val name: PlatformDTO = PlatformDTO.Desktop
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun selectLanguage(selectionLocale: Languages) {
    val locale = Locale.of(languagesMap[selectionLocale] ?: Locale.getDefault().toLanguageTag())
    AppLocale.set(locale.toLanguageTag())
    Locale.setDefault(locale)
}

actual fun getLanguage(): Languages {
    return languagesMap.filter { (_, value) ->
        Locale.getDefault().toLanguageTag() == value
    }.keys.lastOrNull() ?: languagesMap.filter { (_, value) ->
        Locale.getDefault().language == value
    }.keys.lastOrNull() ?: Languages.EN
}

@Composable
actual fun getContext(): Any? = null