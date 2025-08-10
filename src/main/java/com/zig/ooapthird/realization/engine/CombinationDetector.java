package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.GameBoard;

public abstract class CombinationDetector {
    // запросы
    /**
     * предусловие: board != null
     * постусловие: result != null && все элементы result соответствуют совпадениям на board
     */
    public abstract List<Combination> findAllMatches(GameBoard board);

    /**
     * предусловие: board != null
     * постусловие: result == (найдены ли хотя бы 1 совпадение)
     */
    public abstract boolean hasMatches(GameBoard board);
}