package com.example.SnapUsers;

import android.widget.ListView;
import com.example.SnapScore.Score;

public class Player {
    private String name;
    private ListView list_score;

    public Player(String name) {
        this.name = name;
        list_score = new ListView();
    }

    public String getName() {
        return name;
    }

    public ListView<Score> getList_score() {
        return list_score;
    }

    public void setName(String name) {
        this.name = name;
    }
}
