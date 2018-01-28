package com.example.ugre.startandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ugre.startandroid.helpers.SettingsManager;

public class SaxActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax);

        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);
        TextView text3 = (TextView) findViewById(R.id.text3);
        TextView text4 = (TextView) findViewById(R.id.text4);

        text1.setTextColor(SettingsManager.getInstance().getColor("text1"));
        text2.setTextColor(SettingsManager.getInstance().getColor("text2"));
        text3.setTextColor(SettingsManager.getInstance().getColor("text3"));
        text4.setTextColor(SettingsManager.getInstance().getColor("text4"));

    }
}
