package com.example.snaptarget;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CongratulationActivity extends AppCompatActivity {
    String player_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);
        player_name = getIntent().getStringExtra(GameActivity.KEYKONG);
        TextView playerCongrat = findViewById(R.id.textView2);
        playerCongrat.setText(player_name);


    }
}
