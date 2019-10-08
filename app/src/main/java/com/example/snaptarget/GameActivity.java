package com.example.snaptarget;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import pl.droidsonroids.gif.GifImageView;

public class GameActivity extends AppCompatActivity {

    private static final String FORMAT = "%02d:%02d";
    public static final String K_SCORE = "K_SCR";
    public static final String K_NAME = "K_NAME";
    public static final String K_GAMEOVER = "K_GAMEOVER";

    private ArrayList<Button> buttonList = new ArrayList<>();
    private ArrayList choixIcon = new ArrayList();

    private GifImageView myGifScreen;
    private CountDownTimer CountTimer;
    private ProgressBar progressBar;

    private String player_name;
    private Random rand = new Random();
    private boolean gameOver = false;
    private int score = 0;
    private long remaining_time;
    private String difficulty;

    /**
     * Directly executed when arriving to this activity.
     * <p>
     * Get the username from the MainActivity activity then set all buttons that will fill the TableLayout of buttons.
     * Fill-in the list of icons that will be backgrounds of every buttons.
     * Set some other fields like the score, disable the clickable statements of buttons and start a first timer before launching the game.
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myGifScreen = findViewById(R.id.gifgame);

        progressBar = findViewById(R.id.progress_bar);

        TextView score_text = findViewById(R.id.text_score);
        score_text.setText("Score : 0 ");

        player_name = getIntent().getStringExtra(MainActivity.KEY);
        difficulty = getIntent().getStringExtra(MainActivity.KEY_DIFF);

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

        if (difficulty.equals("3")) {
            choixIcon.add(R.drawable.eye);
            choixIcon.add(R.drawable.slifer);
            choixIcon.add(R.drawable.radragon);
            choixIcon.add(R.drawable.obelisk);
            choixIcon.add(R.drawable.jinzo);
            choixIcon.add(R.drawable.timewizard);
        }
        else if (difficulty.equals("2")) {
            choixIcon.add(R.drawable.jinzo);
            choixIcon.add(R.drawable.timewizard);
        }

        choixIcon.add(R.drawable.dbyb);
        choixIcon.add(R.drawable.kuriboh);
        choixIcon.add(R.drawable.darkmagician);
        choixIcon.add(R.drawable.exodia);

        random_all();
        buttons_free(false);

        final Handler handler = new Handler();
        final TextView textView = findViewById(R.id.textView123);
        final java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(3);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(n.get()));
                if (n.getAndDecrement() >= 1)
                    handler.postDelayed(this, 1000);
                else {
                    textView.setVisibility(View.GONE);
                    launchTimer();
                }
            }
        };
        handler.postDelayed(counter, 1000);
    }

    /**
     * Make the CountTimer object ready to be launch at any time.
     * <p>
     * Contain two functions that define their own steps at the execution time :
     * <p>
     * - onTick : launched when the CountTimer is called. In order to display the counter on the screen, this function is recalled every single time define by the 'interval' parameters.
     * It is basically keeping in memory the time passed during is first execution and display it in a String format define by the constant {FORMAT}.
     * Store the remaining time after each call to allow the application to recover this value.
     * <p>
     * - onFinish : call the function {gameIsFinish()}
     *
     * @param timer_count TextView containing the timer.
     * @param millisecs   Starting time of the timer.
     * @param interval    Interval of time that is defining how the timer is refreshed.
     * @return CountTimer object which have been already set with the previous parameters.
     */
    public CountDownTimer getTimer(final TextView timer_count, long millisecs, int interval) {
        CountTimer = new CountDownTimer(millisecs, interval) {
            public void onTick(long millisUntilFinished) {

                timer_count.setText("" + String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                if (millisUntilFinished < 10000) {
                    timer_count.setTextColor(Color.RED);
                }
                remaining_time = millisUntilFinished;
                progressBar.setProgress((int)millisUntilFinished);
                if (difficulty.equals("3")) {
                    if (millisUntilFinished % 2 == 0)
                        random_all();
                }
            }

            public void onFinish() {
                gameIsFinish();
            }
        };
        return CountTimer;
    }

    /**
     * Automatically launched when the milliseconds of CountTimer are equals to 0. Set several behaviors like changing the background resource, disable all buttons, and start the next
     * activity (CongratulationActivity). It can be programmatically call by the function {ActionColorButton()} when the player clicked on a 'forbidden' button.
     * <p>
     * Separate function from onFinish to allow the destruction of the CountTimer without stopping the execution of the Handler below.
     */
    public void gameIsFinish() {
        TextView timer_count = findViewById(R.id.timer);
        timer_count.setTextSize(20);
        timer_count.setText(R.string.game_over);

        buttons_free(false);

        myGifScreen.setBackgroundResource(R.drawable.gifeclair);

        CountTimer.cancel();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), CongratulationActivity.class);
                intent.putExtra(K_GAMEOVER, gameOver);
                intent.putExtra(K_SCORE, Integer.toString(score));
                intent.putExtra(K_NAME, player_name);
                intent.putExtra(MainActivity.KEY_DIFF, difficulty);
                startActivity(intent);
            }
        }, 2000);
    }

    /**
     * Call the function setting the CountDownTimer in the appropriate TextView.
     * Disable the button containing the target image and enable the clickable buttons contained in the TableLayout.
     * <p>
     * Define a first image for the target by selecting one in the buttonList and link the corresponding tag.
     */
    public void launchTimer() {
        final TextView timer_count = findViewById(R.id.timer);
        getTimer(timer_count, 60000, 1000).start();

        Button butt_play = findViewById(R.id.button19);
        butt_play.setEnabled(false);

        int r = rand.nextInt(buttonList.size());
        while (buttonList.get(r).getTag().equals(choixIcon.size() - 1))
            r = rand.nextInt(buttonList.size());

        butt_play.setBackground(buttonList.get(r).getBackground());
        butt_play.setTag(buttonList.get(r).getTag());

        buttons_free(true);
    }

    /**
     * Enable or disable all buttons of the buttonList list.
     *
     * @param choice Allow the function the enable or disable buttons of the buttonList if it respectively equal to true or false.
     */
    private void buttons_free(boolean choice) {
        Button mySelectedButton;
        // Disable buttons after that the game is over.
        for (int i = 0; i < buttonList.size(); i++) {
            mySelectedButton = buttonList.get(i);
            mySelectedButton.setEnabled(choice);
        }
    }

    /**
     * Give a random image to every buttons of the buttonList list.
     * <p>
     * Call when the activity starts or when the player clicked on a wrong button.
     */
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

    /**
     * Define the behavior of the application according to the button that have been clicked each time the target display a new image.
     * <p>
     * Call each time the player clicked on a button (TableLayout).
     * <p>
     * Compare the tag of the target and the clicked button :
     * - if equals : the score is incremented by 3, the target button and the clicked one are randomly set with a new image.
     * - if not equals : the score is decremented by 1, the target button and all other buttons are randomly set with a new image.
     * - if equals to 'exodia' (index in buttonList = choixIcon.size()) : the game is finished, the variable 'gameOver' is set to true, the {onFinish()} method of the timer is call.
     *
     * @param v View on the button clicked.
     */
    public void ActionColorButton(View v) {

        // Get id of button_target, score_textView and timer_count;
        TextView score_text = findViewById(R.id.text_score);
        TextView timer_count = findViewById(R.id.timer);
        Button butt_target = findViewById(R.id.button19);

        // Compare values of target button and actioned one
        if (v.getTag().equals(choixIcon.size() - 1)) {
            // Click on Exodia - GAME OVER
            gameOver = true;
            CountTimer.onFinish();
        } else if (v.getTag().equals(butt_target.getTag())) {
            // equals = we select a new random button from those that have been already set
            int r = rand.nextInt(buttonList.size());
            while (buttonList.get(r).getTag().equals(choixIcon.size() - 1)) {
                r = rand.nextInt(buttonList.size());
            }
            // We set a new background to the target button and the new corresponding tag. CountTimer incremented by 2 seconds.
            butt_target.setBackground(buttonList.get(r).getBackground());
            butt_target.setTag(buttonList.get(r).getTag());
            CountTimer.cancel();
            CountTimer = getTimer(timer_count, remaining_time + 1000, 1000).start();
            score = score < 50 ? score + 3 : score + (3 * (score / 50));
        } else {
            random_all();
            // not equals = we select a new random button from those that have been already set
            int r = rand.nextInt(buttonList.size());
            while (buttonList.get(r).getTag().equals(choixIcon.size() - 1)) {
                r = rand.nextInt(buttonList.size());
            }
            // We set a new background to the target button and the new corresponding tag
            butt_target.setBackground(buttonList.get(r).getBackground());
            butt_target.setTag(buttonList.get(r).getTag());
            score = score < 100 ? score - 1 : score - (1 * (score / 10));
        }

        // Set a random background to the button
        int r = rand.nextInt(choixIcon.size() - 1);
        // Decrease the chance that 'exodia' is really selected to be in the display buttons. It have to be randomly selected twice to be really integrated in the table containing clickable buttons.
        if (r == choixIcon.size() - 1) {
            r = rand.nextInt(choixIcon.size() - 1);
        }
        v.setBackgroundResource((Integer) choixIcon.get(r));
        v.setTag(r);
        score_text.setText("Score : " + score);
    }
}