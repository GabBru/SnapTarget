package com.example.snaptarget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {

    private static final String FORMAT = "%02d:%02d:%02d";
    private int seconds, minutes;
    Button back_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final TextView timer_count = findViewById(R.id.timer);

        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {

                timer_count.setText("" + String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                timer_count.setText("Game Over !");
            }
        }.start();
    }


    public void win_page(View v) {
        Intent intent = new Intent(this, CongratulationActivity.class);
        startActivity(intent);
    }
    public void back (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
