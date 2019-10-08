package com.example.snaptarget;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CongratulationActivity extends AppCompatActivity {

    public static final String KEY_SAVE = "KEY_SAVE";
    public static final String SHARED_PREF = "SHARED_PREF";
    public static final String KEY_SCORE = "KEY_SCORE";

    private String player_name;
    private String score;
    private boolean gameOver;
    private String difficulty;

    /**
     * Directly executed when arriving to this activity.
     * <p>
     * Basically, it checks the value of the passed boolean value 'gameOver' from GameActivity.
     * - if true : Set the appropriate background resource as "@drawable/backgroundover" and make invisible some buttons like 'Save' and some textView like username and congratulations message.
     * - if false : Keep the default background resource as "@drawable/gifbackground" and display all information like score, username, congratulation message ...
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);

        player_name = getIntent().getStringExtra(GameActivity.K_NAME);
        gameOver = getIntent().getExtras().getBoolean(GameActivity.K_GAMEOVER);
        difficulty = getIntent().getExtras().getString(MainActivity.KEY_DIFF);

        TextView text_name = findViewById(R.id.textView_name);
        TextView score_result = findViewById(R.id.score_result);
        TextView text_congrat = findViewById(R.id.textView);
        Button button_save = findViewById(R.id.button);
        Button replay = findViewById(R.id.button_replay);
        ConstraintLayout constraintLayout = findViewById(R.id.cLayoutCongrat);

        text_name.setText(player_name);

        if (gameOver) {
            constraintLayout.setBackgroundResource(R.drawable.backgroundover);
            button_save.setVisibility(View.INVISIBLE);
            replay.setVisibility(View.VISIBLE);
            score_result.setGravity(Gravity.BOTTOM);
            text_congrat.setText(R.string.text_over);
            text_name.setVisibility(View.GONE);

        } else {
            score = getIntent().getStringExtra(GameActivity.K_SCORE);
            score_result.setText("SCORE " + score);
        }
    }

    /**
     * Recharge the previous activity (GameActivity) when clicked. The current score will be reset in the GameActivity but keep the username as is.
     *
     * @param v View on the button clicked.
     */
    public void startNewGame(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(MainActivity.KEY_DIFF, difficulty);
        startActivity(intent);
    }

    /**
     * Save function launched after clicking on the save button. It will save the username and the referenced score on the SharedPreferences.
     * <p>
     * Finally redirect the user to the menu page where he can see results or launch a new game.
     *
     * @param v View on the button clicked.
     */
    public void saveGame(View v) {

        String saving = getString(R.string.saving);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        postSave();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
        builder.setView(R.layout.dialog_save);
        builder.create().show();
    }

    /**
     * {saveGame()} wrap function.
     */
    public void postSave() {
        AlertDialog.Builder builder_postSave = new AlertDialog.Builder(this);
        builder_postSave.setView(R.layout.dialog_save_load);
        builder_postSave.create().show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                sharedPreferences.edit().putString(KEY_SAVE, player_name).apply();
                sharedPreferences.edit().putString(KEY_SCORE, score).apply();

                Intent intent = new Intent(CongratulationActivity.this, MainActivity.class);
                startActivity(intent);

            }
        }, 3000);
    }

        //      SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
//      String string = sharedPreferences1.getString(KEY_SAVE, "Score non enregistré ... ");
}



