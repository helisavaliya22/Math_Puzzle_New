package com.example.math_puzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.math_puzzle.R;

public class MainActivity extends AppCompatActivity {

    TextView continue1,puzzle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continue1 = findViewById(R.id.continue1);
        puzzle = findViewById(R.id.puzzle);

        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}