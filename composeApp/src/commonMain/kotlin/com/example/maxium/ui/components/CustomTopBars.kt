package com.example.maxium.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.maxium.ui.components.modifiers.customClickable
import com.example.maxium.ui.theme.Dimens
import maxium.composeapp.generated.resources.Res
import maxium.composeapp.generated.resources.ic_back
import org.jetbrains.compose.resources.vectorResource

@Composable
fun BackTopBar(
    modifier: Modifier = Modifier, title: String, onClick: () -> Unit
) {
    Box {
        Row(
            modifier = modifier.fillMaxWidth().padding(bottom = Dimens.paddingMd)
                .padding(top = Dimens.paddingXl),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier.customClickable(onClick = onClick)
            ) {
                Icon(
                    modifier = Modifier.size(Dimens.iconMd),
                    imageVector = vectorResource(Res.drawable.ic_back),
                    contentDescription = null
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}