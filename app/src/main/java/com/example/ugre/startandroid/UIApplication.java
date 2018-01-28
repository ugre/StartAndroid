package com.example.ugre.startandroid;

import android.app.Application;

import com.example.ugre.startandroid.parsers.SettingsParser;

/**
 * Created by ugre9 on 28/01/2018.
 */

public class UIApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SettingsParser settingsParser = new SettingsParser(getApplicationContext());
        settingsParser.parseXML();
    }
}
