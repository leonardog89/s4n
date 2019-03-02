package com.example.leonardo.s4n


import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration


class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext)

        // create realm configuration
        val defaultConfig = RealmConfiguration.Builder()
            .schemaVersion(0)
            .deleteRealmIfMigrationNeeded()
            .name("s4n")
            .build()
        Realm.setDefaultConfiguration(defaultConfig)
    }
}