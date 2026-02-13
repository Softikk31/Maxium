package com.example.maxium

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class AndroidPlatform : Platform {
    override val name: PlatformDTO = PlatformDTO.Android
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun openLanguageSettings(context: Any) {
    val context = context as Context

    val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Intent(Settings.ACTION_APP_LOCALE_SETTINGS).apply {
            data = Uri.fromParts("package", context.packageName, null)
        }
    } else {
        Intent(Settings.ACTION_LOCALE_SETTINGS)
    }
    context.startActivity(intent)
}

@Composable
actual fun getContext(): Any? = LocalContext.current