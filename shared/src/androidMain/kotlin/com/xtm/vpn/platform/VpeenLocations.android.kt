package com.xtm.vpn.platform

import com.xtm.vpn.core.VpeenEngine
import com.xtm.vpn.domain.config.VpeenLocation

actual suspend fun loadVpeenLocations(): List<VpeenLocation> = VpeenEngine.fetchFreeLocations()
