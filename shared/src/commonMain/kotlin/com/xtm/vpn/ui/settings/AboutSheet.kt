@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.xtm.vpn.ui.settings


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.xtm.vpn.shared.resources.Res
import com.xtm.vpn.shared.resources.*
import com.xtm.vpn.platform.AppInfo
import com.xtm.vpn.ui.components.MorphingBlob
import com.xtm.vpn.ui.theme.SpiderGradients
import com.xtm.vpn.ui.platform.rememberAppSheetState


@Composable
fun AboutSheet(onDismiss: () -> Unit) {

    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = rememberAppSheetState()) {
        Column(
            Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, bottom = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            MorphingBlob(
                progress = 0.5f,
                brush = SpiderGradients.connected,
                modifier = Modifier.size(96.dp),
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_spider_glyph),
                    contentDescription = stringResource(Res.string.app_name),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(70.dp),
                )
            }
            Text(
                stringResource(Res.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
            )
            Text(
                stringResource(Res.string.about_version, AppInfo.versionName),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                stringResource(Res.string.about_built_on),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )

        }
    }
}
