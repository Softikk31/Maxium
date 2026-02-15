package com.example.maxium.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.maxium.AppLocale
import com.example.maxium.screens.WelcomeScreen
import com.example.maxium.screens.settings.SelectLanguageScreen

@Composable
fun NavActivity() {
    val configuration = Config.config
    val backStack = rememberNavBackStack(configuration, WelcomeRoute)
    val customAppLocale by AppLocale.locale.collectAsState()

    key(customAppLocale) {
        Surface(
            color = MaterialTheme.colorScheme.surface
        ) {
            NavDisplay(
                backStack = backStack,
                entryProvider = { key ->
                    when (key) {
                        is WelcomeRoute -> {
                            NavEntry(WelcomeRoute) {
                                WelcomeScreen(backStack)
                            }
                        }

                        is LanguageRoute -> {
                            NavEntry(LanguageRoute) {
                                SelectLanguageScreen(backStack)
                            }
                        }

                        is LoginEmailRoute -> {
                            NavEntry(LoginEmailRoute) {

                            }
                        }

                        is EmailCodeRoute -> {
                            NavEntry(EmailCodeRoute) {

                            }
                        }

                        is LoginPasswordRoute -> {
                            NavEntry(LoginPasswordRoute) {

                            }
                        }

                        is PasswordCodeRoute -> {
                            NavEntry(PasswordCodeRoute) {

                            }
                        }

                        is ChatsRoute -> {
                            NavEntry(ChatsRoute) {

                            }
                        }

                        is ContactsRoute -> {
                            NavEntry(ContactsRoute) {

                            }
                        }

                        is ProfileRoute -> {
                            NavEntry(ProfileRoute) {

                            }
                        }

                        is ChatRoute -> {
                            NavEntry(ChatRoute) {

                            }
                        }

                        else -> {
                            NavEntry(key) {
                                Text("Unknown screen: ${key::class.simpleName}")
                            }
                        }
                    }
                }
            )
        }
    }
}