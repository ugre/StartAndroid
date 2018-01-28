package com.example.ugre.startandroid.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ugre.startandroid.R;

import java.util.ArrayList;

/**
 * Created by ugre9 on 20/01/2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private LayoutInflater layoutInflater;
    private Activity mActivity;

    public MyRecyclerAdapter(ArrayList<String> mData, Activity mActivity) {
        this.mData = mData;
        this.layoutInflater = LayoutInflater.from(mActivity);
        this.mActivity = mActivity;
    }

    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.ViewHolder holder, int position) {

        final String string = mData.get(position);

        holder.text.setText(string);
        holder.number.setText(String.valueOf(position+1));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Holder

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text, number;

        public ViewHolder(View holder)
        {
            super(holder);

            text = (TextView) holder.findViewById(R.id.text);
            number = (TextView) holder.findViewById(R.id.number);
        }
    }
}
