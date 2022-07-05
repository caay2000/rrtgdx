package com.github.caay2000.rrt

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application

object DesktopLauncher {

    @JvmStatic
    fun main(arg: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration()
        config.setForegroundFPS(60)
        config.setTitle("RRTGDX")
        Lwjgl3Application(RRTGdxGame(), config)
    }
}
