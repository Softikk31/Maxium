package com.example.maxium

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.os.LocaleListCompat
import java.util.Locale

class AndroidPlatform : Platform {
    override val name: PlatformDTO = PlatformDTO.Android
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun selectLanguage(selectionLocale: Languages) {
    val locale = LocaleListCompat.forLanguageTags(languagesMap[selectionLocale])
    AppLocale.set(locale.toLanguageTags())
    AppCompatDelegate.setApplicationLocales(locale)
}

actual fun getLanguage(): Languages {
    return languagesMap.filter { (_, value) ->
        AppCompatDelegate.getApplicationLocales().toLanguageTags() == value
    }.keys.lastOrNull() ?: languagesMap.filter { (_, value) ->
        Locale.getDefault().language == value
    }.keys.lastOrNull() ?: Languages.EN
}

@Composable
actual fun getContext(): Any? = LocalContext.current