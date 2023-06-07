package com.example.math_puzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.math_puzzle.R;

public class Level_Board_Activity extends AppCompatActivity {

    ImageView skip,hint,game_board,delete;
    TextView level_display,submit,n1,n2,n3,n4,n5,n6,n7,n8,n9,n0;
    EditText ans_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_board);

        skip = findViewById(R.id.skip);
        hint = findViewById(R.id.hint);
        game_board = findViewById(R.id.game_board);
        delete = findViewById(R.id.delete);
        level_display = findViewById(R.id.level_display);
        submit = findViewById(R.id.submit);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n0 = findViewById(R.id.n0);
        ans_txt = findViewById(R.id.ans_txt);
    }
}