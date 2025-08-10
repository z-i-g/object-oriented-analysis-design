package com.zig.ooapthird.realization.statistic;

public class Score {
    private int points = 0;

    public void addPoints(int p) {
        points += p;
    }

    public int getCurrentScore() {
        return points;
    }
}