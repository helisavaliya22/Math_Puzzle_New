package com.example.math_puzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.math_puzzle.R;

public class Win_Page_Activity extends AppCompatActivity {

    TextView level_complete,continue2,main_menu;
    ImageView share;
    int levelNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_page);

        level_complete = findViewById(R.id.level_complete);
        continue2 = findViewById(R.id.continue2);
        main_menu = findViewById(R.id.main_menu);
        share = findViewById(R.id.share);

        levelNo = getIntent().getIntExtra("level",0);//6
        Log.d("TTT", "onCreate: WinPage levelNo="+levelNo);

        level_complete.setText("PUZZLE "+ levelNo +" COMPLETED");//6

        continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Win_Page_Activity.this, Level_Board_Activity.class);
                intent.putExtra("level", levelNo);//6
                startActivity(intent);
                finish();
            }
        });
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Win_Page_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}