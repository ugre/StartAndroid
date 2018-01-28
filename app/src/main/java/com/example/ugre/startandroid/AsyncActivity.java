package com.example.ugre.startandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncActivity extends Activity implements View.OnClickListener{

    Button btnLoad, btnStart, btnStop;
    ProgressBar progressBar;
    TextView txtCount;

    Handler handler;
    Runnable runnable;
    int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        btnLoad = findViewById(R.id.btnLoad);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        progressBar = findViewById(R.id.progressBar);
        txtCount = findViewById(R.id.txtCount);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (count == 0)
                    handler.removeCallbacks(this);
                else
                {
                    count--;
                    txtCount.setText(String.valueOf(count));
                    handler.postDelayed(runnable, 1000);
                }
            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLoad:
                new LongOperation().execute("");
                break;
            case R.id.btnStart:
                handler.post(runnable);
                break;
            case R.id.btnStop:
                handler.removeCallbacks(runnable);
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    private class LongOperation extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i <= 5; i++) {
                publishProgress(i*20);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(AsyncActivity.this, result, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPreExecute() {
            Toast.makeText(AsyncActivity.this, "Started!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }
    }
}
