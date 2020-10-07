package com.example.playground

import android.app.Application
import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module

class PlayApplication : Application() {

    private var applicationScope: Scope? = null

    override fun onCreate() {
        super.onCreate()

        applicationScope = Toothpick.openScope(this)
        applicationScope?.installModules(AppModule(this))
    }

    class AppModule(app: Application) : Module() {

        init {
            bind(Application::class.java).toInstance(app)
        }
    }
}