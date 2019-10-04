package com.example.snaptarget;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifImageView;

public class GameActivity extends AppCompatActivity {

    private static final String FORMAT = "%02d:%02d";
    public static final String K_SCORE = "K_SCR";
    public static final String K_NAME = "K_NAME";

    private ArrayList<Button> buttonList = new ArrayList<>();
    private ArrayList choixIcon = new ArrayList();
    private Random rand = new Random();
    private int score = 0;
    private String player_name;
    private GifImageView myGifScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myGifScreen = findViewById(R.id.gifgame);

        TextView score_text = findViewById(R.id.text_score);
        score_text.setText("Score : 0 ");

        player_name = getIntent().getStringExtra(MainActivity.KEY);

        TextView player = findViewById(R.id.name_player);
        player.setText(player_name);

        Button butt_play = findViewById(R.id.button19);
        butt_play.setText("Go!");

        buttonList.add((Button) findViewById(R.id.button2));
        buttonList.add((Button) findViewById(R.id.button5));
        buttonList.add((Button) findViewById(R.id.button6));
        buttonList.add((Button) findViewById(R.id.button7));
        buttonList.add((Button) findViewById(R.id.button8));
        buttonList.add((Button) findViewById(R.id.button9));
        buttonList.add((Button) findViewById(R.id.button10));
        buttonList.add((Button) findViewById(R.id.button11));
        buttonList.add((Button) findViewById(R.id.button12));
        buttonList.add((Button) findViewById(R.id.button13));
        buttonList.add((Button) findViewById(R.id.button14));
        buttonList.add((Button) findViewById(R.id.button15));
        buttonList.add((Button) findViewById(R.id.button16));
        buttonList.add((Button) findViewById(R.id.button17));
        buttonList.add((Button) findViewById(R.id.button18));
        buttonList.add((Button) findViewById(R.id.button20));

        choixIcon.add(R.drawable.dbyb);
        choixIcon.add(R.drawable.exodia);
        choixIcon.add(R.drawable.kuriboh);
        choixIcon.add(R.drawable.darkmagician);

        setTagToButton(buttonList);
        random_all();
        buttons_free(false);
    }

    public CountDownTimer getTimer(final TextView timer_count, int millisecs, int interval) {
        CountDownTimer CountTimer = new CountDownTimer(millisecs, interval) {
            public void onTick(long millisUntilFinished) {

                timer_count.setText("" + String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                if (millisUntilFinished < 10000) {
                    timer_count.setTextColor(Color.RED);
                }
            }

            public void onFinish() {
                timer_count.setTextSize(20);
                timer_count.setText(R.string.game_over);

                myGifScreen.setBackgroundResource(R.drawable.gifeclair);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), CongratulationActivity.class);
                        intent.putExtra(K_SCORE, Integer.toString(score));
                        intent.putExtra(K_NAME, player_name);
                        startActivity(intent);
                    }
                }, 2000);
            }
        };
        return CountTimer;
    }

    public void setTagToButton(ArrayList<Button> list){
        if (list.isEmpty())
            return;

        for (int i = 0; i < list.size(); i++){
            list.get(i).setTag(i);
        }
    }

    public void launchTimer(View v) {
        final TextView timer_count = findViewById(R.id.timer);
        getTimer(timer_count, 60000, 1000).start();
        Button butt_play = findViewById(v.getId());
        butt_play.setText("");
        butt_play.setEnabled(false);

        int r = rand.nextInt(buttonList.size());
        butt_play.setBackground(buttonList.get(r).getBackground());
        butt_play.setTag(buttonList.get(r).getTag());

        buttons_free(true);
    }

    private void buttons_free(boolean choice) {
        Button mySelectedButton;
        // Disable buttons after that the game is over.
        for (int i = 0; i < buttonList.size(); i++) {
            mySelectedButton = buttonList.get(i);
            mySelectedButton.setEnabled(choice);
        }
    }

    public void random_all() {
        // Set random color when arriving on this Activity
        Button mySelectedButton;
        for (int i = 0; i < buttonList.size(); i++) {
            int r = rand.nextInt(choixIcon.size());
            mySelectedButton = buttonList.get(i);
            mySelectedButton.setBackgroundResource((Integer) choixIcon.get(r));
            mySelectedButton.setTag(r);
        }
    }

    public void ActionColorButton(View v) {


        int r = rand.nextInt(choixIcon.size());
        v.setBackgroundResource((Integer) choixIcon.get(r));
        v.setTag(r);

        TextView score_text = findViewById(R.id.text_score);
        Button butt_target = findViewById(R.id.button19);

        if (v.getTag().equals(butt_target.getTag())) {
            r = rand.nextInt(buttonList.size());
            butt_target.setBackground(buttonList.get(r).getBackground());
            butt_target.setTag(buttonList.get(r).getTag());
            score += 3;
        } else {
            score -= 1;
        }

        score_text.setText("Score : " + score);
    }
}
