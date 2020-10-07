package com.example.playground

import android.app.Application
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestInjectable @Inject constructor(
    private val application: Application
) {
    fun doStuff() {
        Log.d("test", application.packageName)
    }
}