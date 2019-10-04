package com.example.snaptarget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CongratulationActivity extends AppCompatActivity {

    public static final String KEY_SAVE = "KEY_SAVE";
    public static final String SHARED_PREF = "SHARED_PREF";

    private String player_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);

        player_name = getIntent().getStringExtra(GameActivity.K_NAME);

        TextView text_name = findViewById(R.id.textView_name);
        text_name.setText(player_name);

        TextView score_result = findViewById(R.id.score_result);
        String score = getIntent().getStringExtra(GameActivity.K_SCORE);
        score_result.setText("SCORE " + score);
    }

    public void startNewGame(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void saveGame(View v) {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        sharedPreferences.edit().putString(KEY_SAVE, player_name).apply();

//      SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
//      String string = sharedPreferences1.getString(KEY_SAVE, "Score non enregistré ... ");


    }
}
