package com.example.maxium.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.Theme
import com.example.maxium.ui.components.CustomPager
import com.example.maxium.ui.components.TextButton
import com.example.maxium.ui.components.modifiers.customClickable
import com.example.maxium.ui.main.SettingsViewModel
import com.example.maxium.ui.navigation.LanguageRoute
import com.example.maxium.ui.theme.Dimens
import com.example.maxium.ui.theme.primaryGradient
import com.sun.tools.javac.util.Log
import maxium.composeapp.generated.resources.Res
import maxium.composeapp.generated.resources.app_name
import maxium.composeapp.generated.resources.current_language
import maxium.composeapp.generated.resources.ic_chevron_down
import maxium.composeapp.generated.resources.ic_logo
import maxium.composeapp.generated.resources.ic_moon
import maxium.composeapp.generated.resources.ic_sun
import maxium.composeapp.generated.resources.welcome_screen_label
import maxium.composeapp.generated.resources.welcome_screen_text_button
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun WelcomeScreen(backStack: NavBackStack<NavKey>, settingsViewModel: SettingsViewModel) {
    val theme by settingsViewModel.theme.collectAsState()
    val isSystemDarkTheme = isSystemInDarkTheme()
    Box(
        modifier = Modifier.fillMaxSize().systemBarsPadding().padding(horizontal = Dimens.paddingMd)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
                .padding(top = Dimens.padding2xl),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier.customClickable {
                        val isDarkTheme = when (theme) {
                            Theme.System -> !isSystemDarkTheme
                            Theme.Light -> true
                            Theme.Dark -> false
                        }

                        val newTheme = when (isDarkTheme) {
                            true -> Theme.Dark
                            false -> Theme.Light
                        }
                        settingsViewModel.setTheme(newTheme)
                    }) {
                    Icon(
                        modifier = Modifier.size(Dimens.iconSm), imageVector = vectorResource(
                            if (theme == Theme.Light) Res.drawable.ic_moon else Res.drawable.ic_sun
                        ), contentDescription = null, tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            }

            Spacer(modifier = Modifier.height(Dimens.padding3xl))

            CustomPager(
                pageCount = 6, content = { page ->
                    val gradient = MaterialTheme.colorScheme.primaryGradient

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.graphicsLayer(alpha = 0.99f).drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        gradient, blendMode = BlendMode.SrcAtop
                                    )
                                }
                            },
                            imageVector = vectorResource(Res.drawable.ic_logo),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.height(Dimens.paddingLg))

                        Text(
                            text = stringResource(Res.string.app_name),
                            style = MaterialTheme.typography.displayLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(Dimens.paddingSm))

                        Text(
                            text = stringResource(Res.string.welcome_screen_label),
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(Dimens.paddingLg))
                    }
                })
        }

        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
                .padding(bottom = Dimens.padding2xl),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.paddingLg)
        ) {
            Row(
                modifier = Modifier.customClickable {
                    backStack.add(LanguageRoute)
                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(Res.string.current_language),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Icon(
                    imageVector = vectorResource(Res.drawable.ic_chevron_down),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            TextButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(Res.string.welcome_screen_text_button),
                onClick = { })
        }
    }
}