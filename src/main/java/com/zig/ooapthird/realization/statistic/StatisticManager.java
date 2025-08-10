package com.zig.ooapthird.realization.statistic;

import com.zig.ooapthird.realization.statistic.Score;

public abstract class StatisticManager {
    private List<Move> moves;
    private Score score;

    /**
     * предусловие: move != null
     * постусловие: moves.size() == old(moves.size()) + 1
     */
    public abstract void recordMove(Move move);

    public abstract List<Move> getHistory(); // Запрос
    public abstract Statistic getFinalStats(); // Запрос
}