package com.example.maxium.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import maxium.composeapp.generated.resources.Res
import maxium.composeapp.generated.resources.inter_variable
import maxium.composeapp.generated.resources.poppins_medium
import org.jetbrains.compose.resources.Font

val Poppins
    @Composable
    get() = FontFamily(Font(Res.font.poppins_medium, FontWeight.Medium))

val Inter
    @Composable
    get() = FontFamily(Font(Res.font.inter_variable))

val Typography
    @Composable
    get() = Typography(

        displayLarge = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 32.sp,
            lineHeight = TextUnit.Unspecified
        ),

        displayMedium = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            lineHeight = TextUnit.Unspecified
        ),

        displaySmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            lineHeight = TextUnit.Unspecified
        ),

        headlineMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            lineHeight = TextUnit.Unspecified
        ),

        headlineSmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            lineHeight = 20.sp
        ),

        titleLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = TextUnit.Unspecified
        ),

        titleMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit.Unspecified
        ),

        titleSmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = TextUnit.Unspecified
        ),

        labelMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = TextUnit.Unspecified
        )
    )