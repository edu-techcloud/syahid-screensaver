package com.screensaver.tv

import android.service.dreams.DreamService
import android.webkit.WebView

class WebDream : DreamService() {
    private var web: WebView? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        isInteractive = false   // sebarang butang pada remote akan menutup screensaver
        isFullscreen = true
        isScreenBright = true
        val w = Web.create(this)
        web = w
        setContentView(w)
    }

    override fun onDetachedFromWindow() {
        web?.destroy()
        web = null
        super.onDetachedFromWindow()
    }
}
