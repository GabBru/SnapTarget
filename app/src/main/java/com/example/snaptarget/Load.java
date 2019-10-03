package com.example.snaptarget;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Load extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        final MediaPlayer music_intro = MediaPlayer.create(Load.this, R.raw.loadsound);
        music_intro.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Load.this, MainActivity.class);
                music_intro.stop();
                startActivity(intent);
            }
        }, 5000);
    }
}
