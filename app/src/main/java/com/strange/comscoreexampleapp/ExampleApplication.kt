package com.strange.comscoreexampleapp

import android.app.Application
import android.os.StrictMode
import com.comscore.Analytics
import com.comscore.PublisherConfiguration
import com.comscore.UsagePropertiesAutoUpdateMode
import com.comscore.util.log.LogLevel

class ExampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )

        val vars: MutableMap<String, String> = HashMap()
        vars["ns_ap_an"] = "test"
        vars["mp_v"] = "test"
        vars["mp_brand"] = "test"
        val publisher = PublisherConfiguration.Builder()
            .publisherId("test")
            .persistentLabels(vars)
            .secureTransmission(true)
            .httpRedirectCaching(false)
            .build()
        Analytics.getConfiguration().addClient(publisher)
        Analytics.getConfiguration()
            .setUsagePropertiesAutoUpdateMode(UsagePropertiesAutoUpdateMode.FOREGROUND_AND_BACKGROUND)
        Analytics.setLogLevel(LogLevel.DEBUG)
        Analytics.getConfiguration().enableImplementationValidationMode()
        Analytics.start(this)

    }
}