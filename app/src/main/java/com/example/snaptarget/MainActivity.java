package com.example.snaptarget;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY = "KEY";
    public static final String KEY_DIFF = "KEY_DIFF";
    private int difficulty;

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

        RatingBar ratingBar = findViewById(R.id.stars);
        final ImageView yugi_style = findViewById(R.id.yugi_face);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (ratingBar.getRating() == 1) {
                    yugi_style.setBackgroundResource(R.drawable.yugimutohappy);
                    difficulty = 1;
                }
                else if (ratingBar.getRating() == 2) {
                    yugi_style.setBackgroundResource(R.drawable.yugimuto);
                    difficulty = 2;
                }
                else if (ratingBar.getRating() == 3) {
                    yugi_style.setBackgroundResource(R.drawable.yugipharaoh);
                    difficulty = 3;
                }
            }
        });
    }

    public void launch(View v) {

        final EditText player_name = findViewById(R.id.input_text_name);
        final String user_name = String.valueOf(player_name.getText());
        String error_username = getString(R.string.pb_user_name);

        if (user_name.equals("") || user_name.length() > 20) {
            // Set an alert toast to inform that the user have to fill-in this field with at least 1 character and 20 max.
            SuperActivityToast superActivityToast = new SuperActivityToast(MainActivity.this);
            superActivityToast.setText(error_username);
            superActivityToast.setDuration(Style.DURATION_MEDIUM);
            superActivityToast.setGravity(Gravity.CENTER);
            superActivityToast.setTextSize(Style.TEXTSIZE_MEDIUM);
            superActivityToast.show();
        } else {
            // Everything right so we can launch the app.
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra(KEY, player_name.getText().toString());
            intent.putExtra(KEY_DIFF, Integer.toString(difficulty));
            startActivity(intent);
        }
    }

    public void see_result(View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void dudududuel(View v) {
        Intent intent = new Intent(this, Load.class);
        startActivity(intent);
    }
}