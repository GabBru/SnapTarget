package com.example.SnapScore;

public class Score {

    private int score, day, month, year, remaining_time;

    public Score(int score, int day, int month, int year, int remaining_time) {
        this.score = score;
        this.day = day;
        this.month = month;
        this.year = year;
        this.remaining_time = remaining_time;
    }

    public int getScore() {
        return score;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getRemaining_time() {
        return remaining_time;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRemaining_time(int remaining_time) {
        this.remaining_time = remaining_time;
    }
}

