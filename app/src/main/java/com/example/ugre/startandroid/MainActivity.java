package com.example.ugre.startandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        Button btnRecycler = (Button) findViewById(R.id.btnStartRecycler);
        Button btnKotlin = (Button) findViewById(R.id.btnStartKotlin);
        Button btnSax = (Button) findViewById(R.id.btnStartSax);
        Button btnComponents = (Button) findViewById(R.id.btnStartCustom);
        Button btnAsync = (Button) findViewById(R.id.btnStartAsync);

        // Setting onClick listener
        btnRecycler.setOnClickListener(this);
        btnKotlin.setOnClickListener(this);
        btnSax.setOnClickListener(this);
        btnComponents.setOnClickListener(this);
        btnAsync.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnStartRecycler:
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
                break;
            case R.id.btnStartKotlin:
                startActivity(new Intent(MainActivity.this, KotlinActivity.class));
                break;
            case R.id.btnStartSax:
                startActivity(new Intent(MainActivity.this, SaxActivity.class));
                break;
            case R.id.btnStartCustom:
                startActivity(new Intent(MainActivity.this, CustomComponentsActivity.class));
                break;
            case R.id.btnStartAsync:
                startActivity(new Intent(MainActivity.this, AsyncActivity.class));
                break;
        }
    }
}
