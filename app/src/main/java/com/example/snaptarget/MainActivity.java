package com.example.snaptarget;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String KEY = "KEY";
    public static final String SHARED_PREF = "SHARED_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a prompt text to input_text_name
        EditText player_pseudo = findViewById(R.id.input_text_name);
        player_pseudo.setHint(R.string.put_name);

        // Using shared preferences
        ArrayList<String> people = new ArrayList<>();
        people.add("Gabriel");
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        sharedPreferences.edit().putString(KEY, "blablabla").apply();

        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        String string = sharedPreferences1.getString(KEY, "blabla");
    }

    public void launch(View v) {

        final EditText player_name = findViewById(R.id.input_text_name);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(KEY, player_name.getText().toString());
        startActivity(intent);
    }

    public void see_result(View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
