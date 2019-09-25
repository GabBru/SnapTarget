package com.example.snaptarget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button launch_game;
    Button see_score;
    EditText player_name;

    String str_playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button login = findViewById(R.id.button_play);
        final Button score = findViewById(R.id.button_score);
        final EditText player_name = findViewById(R.id.input_text_name);
    }

    public void launch(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void see_result(View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void clear_texte (){
        TextView textC = new TextView("");
        return textC;




    }
}

