package com.example.math_puzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.math_puzzle.Config;
import com.example.math_puzzle.R;

public class MainActivity extends AppCompatActivity {

    TextView continue1,puzzle;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    int lastLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continue1 = findViewById(R.id.continue1);
        puzzle = findViewById(R.id.puzzle);

        preferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor=preferences.edit();

        lastLevel=preferences.getInt("lastLevel",0);//5
        Log.d("TTT", "onCreate: LastLevel="+lastLevel);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Level_Board_Activity.class);
                intent.putExtra("level", lastLevel);//5
                startActivity(intent);
            }
        });

        puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lock_Page_Activity.class);
                startActivity(intent);
            }
        });
    }
}