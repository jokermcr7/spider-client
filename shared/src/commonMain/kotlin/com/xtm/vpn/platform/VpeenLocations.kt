package com.xtm.vpn.platform

import com.xtm.vpn.domain.config.VpeenLocation

expect suspend fun loadVpeenLocations(): List<VpeenLocation>
