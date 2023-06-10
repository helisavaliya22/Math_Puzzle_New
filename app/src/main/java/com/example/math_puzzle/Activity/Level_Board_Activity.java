package com.example.math_puzzle.Activity;

import static com.example.math_puzzle.Activity.MainActivity.editor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.math_puzzle.Config;
import com.example.math_puzzle.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Level_Board_Activity extends AppCompatActivity {

    ImageView skip, hint, game_board, delete;
    TextView level_display, submit, n1, n2, n3, n4, n5, n6, n7, n8, n9, n0;
    EditText ans_txt;
    int levelNo;
    String ans = "";
    ArrayList imgArr = new ArrayList<>();

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

        levelNo = getIntent().getIntExtra("level",0);//
        Log.d("TTT", "onCreate: LastLevel in BoardActvity="+levelNo);
        level_display.setText("LEVEL" + (levelNo + 1));//0
//        getImagesFromAssets();

        String[] images = new String[0];

        try {
            images = getAssets().list("images/");
            imgArr = new ArrayList<String>(Arrays.asList(images));
            imgArr.remove("android-logo-mask.png");
            imgArr.remove("android-logo-shine.png");
            imgArr.remove("clock_font.png");
            imgArr.remove("progress_font.png");
            Log.d("YYY", "onCreate: imagesList After=" + imgArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        InputStream inputstream = null;
        try {
            inputstream = getAssets().open("images/" + imgArr.get(levelNo));//0
            Drawable drawable = Drawable.createFromStream(inputstream, null);
            System.out.println("input Stream=" + drawable);
            game_board.setImageDrawable(drawable);
            inputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ansLogic();
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelNo++;
                editor.putString("levelStatus"+levelNo,"skip");
                editor.putInt("lastLevel",levelNo);
                editor.commit();
                level_display.setText("LEVEL" + (levelNo + 1));
                InputStream inputstream = null;
                try {
                    inputstream = getAssets().open("images/" + imgArr.get(levelNo+1));
                    Drawable drawable = Drawable.createFromStream(inputstream, null);

                    game_board.setImageDrawable(drawable);
                    inputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

       // level_display.setText("LEVEL" + (levelNo + 1));
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = Integer.parseInt(ans);
                if (Config.AnsArr[levelNo].equals(ans_txt.getText().toString()))//0
                {
                    Intent intent = new Intent(Level_Board_Activity.this, Win_Page_Activity.class);

                    editor.putString("levelStatus"+levelNo,"win");// levelStatus0=win
                    editor.putInt("lastLevel",levelNo);//0
                    editor.commit();
                    levelNo++;
                    intent.putExtra("level", levelNo);//7
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Level_Board_Activity.this, "Wrong!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void ansLogic() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = ans.substring(0, ans.length() - 1);
                ans_txt.setText(ans);
            }
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("1");
                ans = ans + 1;
                ans_txt.setText(ans);
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("2");
                ans = ans + 2;
                ans_txt.setText(ans);
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("3");
                ans = ans + 3;
                ans_txt.setText(ans);
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("4");
                ans = ans + 4;
                ans_txt.setText(ans);
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("5");
                ans = ans + 5;
                ans_txt.setText(ans);
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("6");
                ans = ans + 6;
                ans_txt.setText(ans);
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("7");
                ans = ans + 7;
                ans_txt.setText(ans);
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("8");
                ans = ans + 8;
                ans_txt.setText(ans);
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("9");
                ans = ans + 9;
                ans_txt.setText(ans);
            }
        });
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_txt.setText("0");
                ans = ans + 0;
                ans_txt.setText(ans);
            }
        });

        Log.d("TTT", "onCreate: LevelBoard levelNo=" + levelNo);
    }

}