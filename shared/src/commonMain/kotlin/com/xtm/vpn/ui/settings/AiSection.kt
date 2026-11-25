package com.xtm.vpn.ui.settings

import com.xtm.vpn.domain.ai.AiAppBridge
import com.xtm.vpn.domain.ai.AiSettings

data class AiSection(
    val settings: AiSettings,
    val onUpdate: (AiSettings) -> Unit,
    val bridge: AiAppBridge,
    val onOpenUrl: (String) -> Unit,

    val languageName: String,
    val languageNative: String,

    val platform: String,
    val appVersion: String,
)
