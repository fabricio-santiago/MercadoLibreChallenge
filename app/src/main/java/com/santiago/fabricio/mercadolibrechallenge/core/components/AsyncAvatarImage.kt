package com.santiago.fabricio.mercadolibrechallenge.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.santiago.fabricio.mercadolibrechallenge.R

@Composable
fun AsyncAvatarImage(
    dataUrl: String,
    modifier: Modifier,
    size: Int,
    padding: Int
) {
    Surface(
        modifier = modifier
            .padding(padding.dp)
            .size(size.dp),
        shape = RoundedCornerShape(20.dp),
    )
    {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(dataUrl)
                .crossfade(true)
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.mipmap.ic_launcher_round).build(),
            contentDescription = "image icon",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                .clearAndSetSemantics {
                    contentDescription = contentDescription
                },
        )
    }
}