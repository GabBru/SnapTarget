package com.example.snaptarget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void win_page(){
        Intent intent = new Intent(this, CongratulationActivity.class);
        startActivity(intent);
    }
}
