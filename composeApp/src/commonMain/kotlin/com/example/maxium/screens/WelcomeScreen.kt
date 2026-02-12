package com.example.maxium.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.maxium.components.CustomPager
import com.example.maxium.components.CustomTextButton
import com.example.maxium.components.modifiers.customClickable
import com.example.maxium.theme.MaxiumTheme
import com.example.maxium.theme.primaryGradient
import maxium.composeapp.generated.resources.Res
import maxium.composeapp.generated.resources.app_name
import maxium.composeapp.generated.resources.english_language
import maxium.composeapp.generated.resources.ic_chevron_down
import maxium.composeapp.generated.resources.ic_logo
import maxium.composeapp.generated.resources.ic_moon
import maxium.composeapp.generated.resources.welcome_screen_label
import maxium.composeapp.generated.resources.welcome_screen_text_button
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Preview
@Composable
fun WelcomeScreen() {
    MaxiumTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Box(
                        modifier = Modifier.customClickable {

                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(22.5.dp),
                            imageVector = vectorResource(Res.drawable.ic_moon),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(80.dp))

                CustomPager(
                    pageCount = 6,
                    content = { page ->
                        val gradient = MaterialTheme.colorScheme.primaryGradient

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                modifier = Modifier
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(
                                                gradient,
                                                blendMode = BlendMode.SrcAtop
                                            )
                                        }
                                    },
                                imageVector = vectorResource(Res.drawable.ic_logo),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.height(22.dp))

                            Text(
                                text = stringResource(Res.string.app_name),
                                style = MaterialTheme.typography.displayLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = stringResource(Res.string.welcome_screen_label),
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Spacer(modifier = Modifier.height(22.dp))
                        }
                    }
                )

                Spacer(modifier = Modifier.height(170.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(Res.string.english_language),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Icon(
                        imageVector = vectorResource(Res.drawable.ic_chevron_down),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                CustomTextButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.welcome_screen_text_button),
                    onClick = { }
                )
            }
        }
    }
}