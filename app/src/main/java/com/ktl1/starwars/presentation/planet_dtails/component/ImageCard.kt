package com.ktl1.starwars.presentation.planet_dtails.component

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
import coil.compose.AsyncImage

@Composable
fun ImageCard(
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
            AsyncImage(
                model = imageData().random(),
                contentDescription = null,
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

fun imageData() = mutableListOf(
    "https://i.picsum.photos/id/842/800/1200.jpg?hmac=BOjkyxv2iNsjN4vOnBQvuiJo5BpZ5cfYCv855pKgvz0",
    "https://i.picsum.photos/id/340/800/1200.jpg?hmac=dh3u9xcOLHK_IHeIC8-lsLUpdgokZmvYyg5kUykfBcg",
    "https://i.picsum.photos/id/556/800/1200.jpg?hmac=Ht6a752AXsadL3VBeQLSdnxcUyYdpnETYRF2KR2exbg",
    "https://i.picsum.photos/id/283/800/1200.jpg?hmac=Hd6aUOD7MWqg-NhVEbvmv2HpOtdbJ0RH3OGXNq1DYbs",
    "https://i.picsum.photos/id/43/800/1200.jpg?hmac=_HXroF6RZ36_8O7esVw8druFAt6Z3Z9WiFLUMPpwK24",
    "https://i.picsum.photos/id/698/800/1200.jpg?hmac=EiHfB-KouESbo9o0BdvWPcSeuyaSZlriN4Nt6Jd8MiI",
    "https://i.picsum.photos/id/958/800/1200.jpg?hmac=KJqXc5KWnqEA-7Jvfg_XLHrleJcdEZQNWYAju0nYVos",
    "https://i.picsum.photos/id/299/800/1200.jpg?hmac=CopXy5xs80dPHxgkIXpHwJI8zyPc3Mxlk2N5-PH2jJ0",
    "https://i.picsum.photos/id/848/800/1200.jpg?hmac=6lPpUFZSMtNQbNOK-DEikT3H4MSNyJHHl6mWUWv69Vc",
    "https://i.picsum.photos/id/361/800/1200.jpg?hmac=SQagm8QFVAUCFV5osxNfP-WodfewxwTPERCAjodXQ1E"

)