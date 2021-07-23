package com.hsmnzaydn.gunluk_burc_android.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hsmnzaydn.gunluk_burc_android.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = Purple700,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.barlowbold, FontWeight.Bold))
    ),
    h1 = TextStyle(
        color = Purple200,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.barlowbold, FontWeight.Bold))
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)