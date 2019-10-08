package com.example.snaptarget;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final RecyclerView rv = findViewById(R.id.ListScore);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(getItems()));
        // data to populate the RecyclerView with


    }

    public List<Pair<String, String>> getItems() {
        sharedPreferences = getSharedPreferences(CongratulationActivity.SHARED_PREF, MODE_PRIVATE);
        String valueName = sharedPreferences.getString(CongratulationActivity.KEY_SAVE, "inconue");
        String valueScore = sharedPreferences.getString(CongratulationActivity.KEY_SCORE, "inconue");
        List<Pair<String, String>> ajout = Arrays.asList(
                Pair.create(valueName, valueScore),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   "),
                Pair.create("Gabriel   ", "1231243515135   "),
                Pair.create("Cedric   ", "2   ")
                );

        return ajout;
    }
}