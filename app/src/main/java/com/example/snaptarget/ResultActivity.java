package com.example.snaptarget;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private List<Pair<String, String>> list;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final RecyclerView rv = findViewById(R.id.ListScore);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter());
        // data to populate the RecyclerView with
    }

//    public List<Pair<String, String>> getItems() {
//
//        sharedPreferences = getSharedPreferences();
//        return list;
//    }
}