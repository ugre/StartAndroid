package com.example.ugre.startandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ugre.startandroid.adapters.MyRecyclerAdapter;

import java.util.ArrayList;

public class RecyclerActivity extends Activity {

    EditText etItem;
    Button btnAddItem;

    RecyclerView mRecyclerView;
    ArrayList<String> mArrayList = new ArrayList<>();
    MyRecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // Init
        etItem = (EditText) findViewById(R.id.etItem);
        btnAddItem = (Button) findViewById(R.id.btnAddItem);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        setDummyData();

        mRecyclerAdapter = new MyRecyclerAdapter(mArrayList, this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setHasFixedSize(true);

        // Listener
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newItem = etItem.getText().toString();
                mArrayList.add(0, newItem);
                mRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setDummyData()
    {
        for (int i=0; i < 100; i++)
            mArrayList.add("Item" + i);
    }
}
