package com.example.ugre.startandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ugre.startandroid.custom_components.CustomImageView;

public class CustomComponentsActivity extends Activity {

    CustomImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_components);

        mImageView = findViewById(R.id.imgBomb);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView.incBomb();
            }
        });
    }
}
