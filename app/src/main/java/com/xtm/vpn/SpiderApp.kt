package com.xtm.vpn

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.svg.SvgDecoder
import com.xtm.vpn.core.XrayController
import com.xtm.vpn.platform.FirefoxVpnCore
import com.xtm.vpn.core.platform.LocaleManager
import com.xtm.vpn.data.settings.SettingsRepository
import com.xtm.vpn.di.AppContainer

class SpiderApp : Application(), SingletonImageLoader.Factory {
    lateinit var container: AppContainer
        private set

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.wrap(base, SettingsRepository.readLanguageTag(base)))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.reassert(SettingsRepository.readLanguageTag(this))
    }

    override fun onCreate() {
        super.onCreate()

        FirefoxVpnCore.dataDirectory = java.io.File(filesDir, "firefoxvpn").absolutePath

        container = AppContainer(this)

        XrayController.warmUp(this)
    }

    override fun newImageLoader(context: PlatformContext): ImageLoader =
        ImageLoader.Builder(context)
            .components { add(SvgDecoder.Factory()) }
            .build()
}
