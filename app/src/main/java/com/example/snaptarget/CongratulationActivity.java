package com.example.snaptarget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CongratulationActivity extends AppCompatActivity {
  
    String player_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);

        String player_name = getIntent().getStringExtra(GameActivity.K_NAME);

        TextView text_name = findViewById(R.id.textView_name);
        text_name.setText(player_name);

        TextView score_result = findViewById(R.id.score_result);
        String score = getIntent().getStringExtra(GameActivity.K_SCORE);
        score_result.setText("SCORE " + score);
    }

    public void startNewGame(View v){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
