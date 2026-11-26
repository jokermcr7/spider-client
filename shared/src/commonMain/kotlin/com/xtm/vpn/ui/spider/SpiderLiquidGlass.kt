package com.xtm.vpn.ui.spider

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * XTM Liquid Glass surface.
 * A raised tinted base remains visible beneath an inset translucent glass face.
 */
fun Modifier.spiderLiquidGlass(
    shape: Shape,
    tint: Color,
    depth: Dp = 4.dp,
    preserveBackground: Boolean = false,
): Modifier = drawWithCache {
    val safeDepth = depth.toPx().coerceAtLeast(0f)
        .coerceAtMost(size.minDimension * 0.18f)

    val faceSize = Size(
        (size.width - safeDepth).coerceAtLeast(0f),
        (size.height - safeDepth).coerceAtLeast(0f),
    )

    val basePath = outlinePath(shape.createOutline(size, layoutDirection, this))
    val facePath = outlinePath(shape.createOutline(faceSize, layoutDirection, this))

    val base = Brush.linearGradient(
        colors = listOf(tint, tint.copy(alpha = 0.78f)),
        start = Offset.Zero,
        end = Offset(size.width, size.height),
    )

    val face = Brush.linearGradient(
        colors = listOf(
            Color.White.copy(alpha = 0.46f),
            tint.copy(alpha = 0.16f),
            Color.White.copy(alpha = 0.10f),
            tint.copy(alpha = 0.24f),
        ),
        start = Offset.Zero,
        end = Offset(faceSize.width, faceSize.height),
    )

    val rim = Brush.linearGradient(
        colors = listOf(
            Color.White.copy(alpha = 0.88f),
            Color.White.copy(alpha = 0.24f),
            tint.copy(alpha = 0.58f),
            Color.White.copy(alpha = 0.52f),
        ),
        start = Offset.Zero,
        end = Offset(faceSize.width, faceSize.height),
    )

    onDrawWithContent {
        if (!preserveBackground) {
            drawPath(basePath, brush = base)
        }
        drawPath(facePath, brush = face)
        drawContent()
        drawPath(facePath, brush = rim, style = Stroke(width = 1.25.dp.toPx()))
        drawPath(
            facePath,
            color = Color.White.copy(alpha = 0.22f),
            style = Stroke(width = 0.55.dp.toPx()),
        )
    }
}

private fun outlinePath(outline: Outline): Path = Path().apply {
    when (outline) {
        is Outline.Rectangle -> addRect(outline.rect)
        is Outline.Rounded -> addRoundRect(outline.roundRect)
        is Outline.Generic -> addPath(outline.path)
    }
}
