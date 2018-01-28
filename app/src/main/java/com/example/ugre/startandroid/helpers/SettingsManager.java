package com.example.ugre.startandroid.helpers;

import android.content.Context;
import android.graphics.Color;

import java.util.HashMap;

/**
 * Created by Praksa2 on 14-Jun-17.
 */

public class SettingsManager {
    private static SettingsManager ourInstance = new SettingsManager();

    private HashMap<String,String> textColors = new HashMap<>();

    public static SettingsManager getInstance() {
        return ourInstance;
    }

    private SettingsManager() {
    }

    public void putColor(String key, String color)
    {
        this.textColors.put(key,color);
    }

    public int getColor(String key)
    {
        String color = this.textColors.get(key);
        return Color.parseColor("#"+color);
    }
}
