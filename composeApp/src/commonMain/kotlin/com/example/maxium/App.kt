package com.example.maxium

import androidx.compose.runtime.Composable
import com.example.maxium.di.commonModules
import com.example.maxium.ui.navigation.NavActivity
import com.example.maxium.ui.theme.MaxiumTheme
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatformTools

@Composable
fun App() {
    if (KoinPlatformTools.defaultContext().getOrNull() == null) {
        startKoin(appDeclaration = {
            modules(commonModules)
        })
    }

    MaxiumTheme {
        NavActivity()
    }
}