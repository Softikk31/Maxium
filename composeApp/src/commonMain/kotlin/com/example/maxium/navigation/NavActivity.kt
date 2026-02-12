package com.example.maxium.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.maxium.screens.WelcomeScreen

@Composable
fun NavActivity() {
    val configuration = Config.config
    val backStack = rememberNavBackStack(configuration, WelcomeRoute)

    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        NavDisplay(
            modifier = Modifier.padding(horizontal = 16.dp),
            backStack = backStack,
            entryProvider = { key ->
                when (key) {
                    is WelcomeRoute -> {
                        NavEntry(WelcomeRoute) {
                            WelcomeScreen()
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