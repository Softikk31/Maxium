package com.example.maxium.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.maxium.components.modifiers.customClickable
import com.example.maxium.theme.primaryGradient

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.primaryGradient,
                RoundedCornerShape(6.dp)
            )
            .customClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.surface
        )
    }
}