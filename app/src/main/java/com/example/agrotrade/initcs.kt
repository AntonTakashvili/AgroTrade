package com.example.agrotrade

import android.app.Application
import com.example.agrotrade.api.ResClient

class initcs:Application() {
    override fun onCreate() {
        super.onCreate()


        ResClient.initClients()
    }
}