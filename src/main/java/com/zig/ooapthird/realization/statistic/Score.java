package com.zig.ooapthird.realization.statistic;

public abstract class Score {
    private int points;

    // команда
    /**
     * предусловие: p > 0
     * постусловие: points == old(points) + p
     */
    public abstract void addPoints(int p);

    //запрос
    public abstract int getCurrentScore();
}