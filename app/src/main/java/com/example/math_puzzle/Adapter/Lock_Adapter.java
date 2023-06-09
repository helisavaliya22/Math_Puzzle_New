package com.example.math_puzzle.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.math_puzzle.Activity.Lock_Page_Activity;
import com.example.math_puzzle.R;

public class Lock_Adapter extends BaseAdapter {
    Lock_Page_Activity lock_page_activity;
    int lock_page_item_layout;
    public Lock_Adapter(Lock_Page_Activity lock_page_activity, int lock_page_item_layout) {
        this.lock_page_activity = lock_page_activity;
        this.lock_page_item_layout = lock_page_item_layout;
    }

    @Override
    public int getCount() {
        return 24;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(lock_page_activity).inflate(R.layout.lock_page_item_layout,parent);

        ImageView imageView = view.findViewById(R.id.lock);
        imageView.setImageResource(R.drawable.lock);
        return view;
    }
}
