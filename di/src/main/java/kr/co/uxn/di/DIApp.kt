package kr.co.uxn.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DIApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}