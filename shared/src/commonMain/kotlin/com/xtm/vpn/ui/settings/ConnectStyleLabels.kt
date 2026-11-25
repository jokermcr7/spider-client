package com.xtm.vpn.ui.settings

import com.xtm.vpn.domain.model.ConnectButtonStyle
import com.xtm.vpn.shared.resources.Res
import com.xtm.vpn.shared.resources.connect_style_bar
import com.xtm.vpn.shared.resources.connect_style_hero
import com.xtm.vpn.shared.resources.connect_style_icon
import com.xtm.vpn.shared.resources.connect_style_pill
import com.xtm.vpn.shared.resources.connect_style_ring
import com.xtm.vpn.shared.resources.connect_style_switch
import org.jetbrains.compose.resources.StringResource

fun ConnectButtonStyle.labelRes(): StringResource = when (this) {
    ConnectButtonStyle.Pill -> Res.string.connect_style_pill
    ConnectButtonStyle.Hero -> Res.string.connect_style_hero
    ConnectButtonStyle.Ring -> Res.string.connect_style_ring
    ConnectButtonStyle.Bar -> Res.string.connect_style_bar
    ConnectButtonStyle.Icon -> Res.string.connect_style_icon
    ConnectButtonStyle.Switch -> Res.string.connect_style_switch
}
