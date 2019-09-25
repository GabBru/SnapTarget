package com.example.snaptarget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    Button back_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void win_page(){
        Intent intent = new Intent(this, CongratulationActivity.class);
        startActivity(intent);
    }
    public void back (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
