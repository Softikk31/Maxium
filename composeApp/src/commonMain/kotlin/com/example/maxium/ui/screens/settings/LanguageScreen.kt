package com.example.maxium.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.maxium.Languages
import com.example.maxium.getLanguage
import com.example.maxium.languagesMap
import com.example.maxium.selectLanguage
import com.example.maxium.ui.components.BackTopBar
import com.example.maxium.ui.components.RadioButton
import com.example.maxium.ui.models.LanguageDisplay
import com.example.maxium.ui.theme.Dimens
import maxium.composeapp.generated.resources.Res
import maxium.composeapp.generated.resources.en_en_language
import maxium.composeapp.generated.resources.en_language
import maxium.composeapp.generated.resources.en_ru_language
import maxium.composeapp.generated.resources.ru_language
import maxium.composeapp.generated.resources.title_topbar_language
import org.jetbrains.compose.resources.stringResource

@Composable
fun SelectLanguageScreen(backStack: NavBackStack<NavKey>) {
    Scaffold(
        modifier = Modifier.fillMaxSize().systemBarsPadding(),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            BackTopBar(
                modifier = Modifier.padding(horizontal = Dimens.paddingMd),
                title = stringResource(Res.string.title_topbar_language),
                onClick = {
                    backStack.removeLastOrNull()
                })
        }) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(languagesMap.keys.toList()) { key ->
                    val selected = getLanguage() == key
                    val languagesDisplay = mapOf(
                        Languages.EN to LanguageDisplay(
                            Res.string.en_language, Res.string.en_en_language
                        ), Languages.RU to LanguageDisplay(
                            Res.string.ru_language, Res.string.en_ru_language
                        )
                    )
                    val languageStringsRes = languagesDisplay[key]
                    RadioButton(selected = selected, onClick = {
                        selectLanguage(key)
                    }, content = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(Dimens.paddingXs)
                        ) {
                            languageStringsRes?.let {
                                Text(
                                    text = stringResource(it.mainName),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                Text(
                                    text = stringResource(it.secondaryName),
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    })
                }
            }
        }
    }
}