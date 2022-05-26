package com.ktl1.starwars.presentation.planet_dtails.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ImageCard(
    painter: Painter,
    name: String,
    orbital_period: String,
    gravity: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomEnd,
            ) {
                Column(
                    modifier = Modifier
                        .height(150.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(name, style = TextStyle(Color.White, fontSize = 32.sp))
                    Text(
                        orbital_period,
                        style = TextStyle(
                            Color.White,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Italic
                        )
                    )
                    Text(
                        gravity,
                        style = TextStyle(
                            Color.White,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
            }
        }
    }
}