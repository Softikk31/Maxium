package com.example.maxium.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Theme
import com.example.domain.usecase.GetThemeUseCase
import com.example.domain.usecase.SetThemeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val setThemeUseCase: SetThemeUseCase, private val getThemeUseCase: GetThemeUseCase
) : ViewModel() {
    private val _theme = MutableStateFlow(Theme.Light)
    val theme = _theme.asStateFlow()

    init {
        viewModelScope.launch {
            getThemeUseCase().collect {
                _theme.value = Theme.entries[it]
            }
        }
    }

    fun setTheme(theme: Theme) {
        viewModelScope.launch {
            setThemeUseCase(theme.ordinal)
        }
    }
}