package com.example.maxium.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CustomPager(pageCount: Int, content: @Composable (Int) -> Unit) {
    val pagerState = rememberPagerState(pageCount = { pageCount })
    HorizontalPager(
        state = pagerState
    ) { page ->
        content(page)
    }
    Row(
        Modifier.wrapContentHeight().fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.outline
            Box(
                modifier = Modifier.padding(horizontal = 3.dp).clip(CircleShape).background(color)
                    .size(6.dp)
            )
        }
    }
}