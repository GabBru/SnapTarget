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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String player_name = getIntent().getStringExtra(MainActivity.KEY);

        TextView player = findViewById(R.id.name_player);
        player.setText(player_name);

//        for (int i = 0; i < buttonList.size(); i++){
//            buttonList(i).setBackgroundColor()
//        }
    }

    public CountDownTimer getTimer(final TextView timer_count, int millisecs, int interval) {
        CountDownTimer CountTimer = new CountDownTimer(millisecs, interval) {
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
        };
        return CountTimer;
    }

    public void launchTimer(View v){
        final TextView timer_count = findViewById(R.id.timer);
        getTimer(timer_count, 60000, 1000).start();
    }

    public void win_page(View v) {
        Intent intent = new Intent(this, CongratulationActivity.class);
        startActivity(intent);
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
