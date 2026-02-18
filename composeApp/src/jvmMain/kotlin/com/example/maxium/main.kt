package com.example.maxium

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.maxium.di.commonModules
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(commonModules)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Maxium",
    ) {
        App()
    }
}