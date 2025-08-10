package com.zig.ooapthird.realization.statistic;

import java.util.List;

public abstract class AbstractStatisticManager {
    private List<Move> moves;
    private AbstractScore score;

    /**
     * предусловие: move != null
     * постусловие: moves.size() == old(moves.size()) + 1
     */
    public abstract void recordMove(Move move);

    public abstract List<Move> getHistory(); // Запрос
    public abstract Statistic getFinalStats(); // Запрос
}