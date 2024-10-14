package com.example.sunnyweather



import android.app.Application

class SunnyWeatherApplication : Application() {

    companion object {
        // 请替换为您的实际 API Token
        const val TOKEN = "1cH6LyFmnIX5X9jv"
    }

    override fun onCreate() {
        super.onCreate()
        // 在这里可以进行全局初始化操作
    }
}
