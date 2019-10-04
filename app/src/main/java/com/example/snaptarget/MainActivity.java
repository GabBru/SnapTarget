package com.example.snaptarget;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public static final String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a prompt text to input_text_name
        EditText player_pseudo = findViewById(R.id.input_text_name);
        player_pseudo.setHint(R.string.put_name);

        MediaPlayer music = MediaPlayer.create(getApplicationContext(), R.raw.yugiohmusicbattle);
        music.setLooping(true);
        music.start();
    }

    public void launch(View v) {

        final EditText player_name = findViewById(R.id.input_text_name);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(KEY, player_name.getText().toString());
        startActivity(intent);
    }

    public void see_result(View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
