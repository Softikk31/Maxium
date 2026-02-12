package com.example.maxium

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.maxium.navigation.NavActivity
import com.example.maxium.theme.MaxiumTheme

@Composable
@Preview
fun App() {
    MaxiumTheme {
        NavActivity()
    }
}