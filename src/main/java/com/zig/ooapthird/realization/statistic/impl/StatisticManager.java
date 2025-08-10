package com.zig.ooapthird.realization.statistic.impl;

import com.zig.ooapthird.realization.statistic.Move;
import com.zig.ooapthird.realization.statistic.Score;
import com.zig.ooapthird.realization.statistic.Statistic;

import java.util.ArrayList;
import java.util.List;

public class StatisticManager {
    private final List<Move> moves = new ArrayList<>();
    private final Score score = new Score();

    public void recordMove(Move move) {
        moves.add(move);
    }

    public List<Move> getHistory() {
        return List.copyOf(moves);
    }

    public Statistic getFinalStats() {
        return new Statistic();
    }
}