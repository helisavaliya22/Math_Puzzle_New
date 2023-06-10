package com.example.math_puzzle.Adapter;

import static com.example.math_puzzle.Activity.MainActivity.preferences;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.math_puzzle.Activity.Lock_Page_Activity;
import com.example.math_puzzle.Activity.MainActivity;
import com.example.math_puzzle.R;

public class Lock_Adapter extends BaseAdapter {
    Lock_Page_Activity lock_page_activity;
    int lock_page_item_layout;
    int lastLevel;
    public Lock_Adapter(Lock_Page_Activity lock_page_activity) {
        this.lock_page_activity = lock_page_activity;

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

        view = LayoutInflater.from(lock_page_activity).inflate(R.layout.lock_page_item_layout,parent,false);

        ImageView lock = view.findViewById(R.id.lock);
        ImageView tick=view.findViewById(R.id.tick);
        TextView levelText=view.findViewById(R.id.levelText);

        //imageView.setImageResource(R.drawable.lock);
        lastLevel= preferences.getInt("lastLevel",-1);
        String levelStatus=preferences.getString("levelStatus"+(position+1),"pending");
//        if(position==0)
//        {
//            lock.setVisibility(View.GONE);
//            levelText.setText(""+(position+1));
//            levelText.setVisibility(View.VISIBLE);
//            if(levelStatus.equals("win"))
//            {
//                tick.setVisibility(View.VISIBLE);
//            }
//
//        }
//        if(levelStatus.equals("win"))
//        {
//            lock.setVisibility(View.GONE);
//            levelText.setText(""+(position+1));
//            levelText.setVisibility(View.VISIBLE);
//            tick.setVisibility(View.VISIBLE);
//
//        }
//        if(position==(lastLevel)) {
//            lock.setVisibility(View.GONE);
//            levelText.setText(""+(position+1));
//            levelText.setVisibility(View.VISIBLE);
//            tick.setVisibility(View.GONE);
//        }
//        if(levelStatus.equals("skip"))
//        {
//            lock.setVisibility(View.GONE);
//            levelText.setText(""+(position+1));
//            levelText.setVisibility(View.VISIBLE);
//            tick.setVisibility(View.GONE);
//        }
        if (levelStatus.equals("win")) {
            tick.setImageResource(R.drawable.tick);
            levelText.setText("" + (position + 1));
            levelText.setVisibility(View.VISIBLE);
        }else if (levelStatus.equals("skip") || position == lastLevel + 1) {
            tick.setImageResource(0);
            levelText.setText("" + (position + 1));
            levelText.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
