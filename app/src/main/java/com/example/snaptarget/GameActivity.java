package com.example.snaptarget;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {

    private static final String FORMAT = "%02d:%02d:%02d";

    ArrayList buttonList = new ArrayList<Button>();
    ArrayList choixCouleur = new ArrayList();
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String player_name = getIntent().getStringExtra(MainActivity.KEY);

        TextView player = findViewById(R.id.name_player);
        player.setText(player_name);

        buttonList.add(R.id.button);
        buttonList.add(R.id.button2);
        buttonList.add(R.id.button3);
        buttonList.add(R.id.button20);
        buttonList.add(R.id.button5);
        buttonList.add(R.id.button6);
        buttonList.add(R.id.button7);
        buttonList.add(R.id.button8);
        buttonList.add(R.id.button9);
        buttonList.add(R.id.button10);
        buttonList.add(R.id.button11);
        buttonList.add(R.id.button12);
        buttonList.add(R.id.button13);
        buttonList.add(R.id.button14);
        buttonList.add(R.id.button15);
        buttonList.add(R.id.button16);

        choixCouleur.add(Color.BLUE);
        choixCouleur.add(Color.GREEN);
        choixCouleur.add(Color.RED);
        choixCouleur.add(Color.YELLOW);

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
                timer_count.setText(R.string.game_over);
            }
        };
        return CountTimer;
    }

    public void launchTimer(View v) {
        final TextView timer_count = findViewById(R.id.timer);
        getTimer(timer_count, 60000, 1000).start();
        Button butt_play = findViewById(R.id.button19);
        butt_play.setEnabled(false);
    }

    public void win_page(View v) {
        Intent intent = new Intent(this, CongratulationActivity.class);
        startActivity(intent);
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

//    public random_all(View v){
//        // Set random color when arriving on this Activity
//        for (int i = 0; i < buttonList.size(); i++) {
//            buttonList.get(i).setBackgroundColor((Integer)choixCouleur.get(rand.nextInt(choixCouleur.size())));
//            generic_button.setBackgroundColor((Integer)choixCouleur.get(rand.nextInt(choixCouleur.size())));
//        }
//    }

    public void randomColor(View v) {
        Button button = findViewById(v.getId());
        button.setBackgroundColor((Integer) choixCouleur.get(rand.nextInt(choixCouleur.size())));
    }
}
