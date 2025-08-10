package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;

import java.util.List;

public abstract class AbstractCombinationDetector {
    // запросы
    /**
     * предусловие: board != null
     * постусловие: result != null && все элементы result соответствуют совпадениям на board
     */
    public abstract List<Combination> findAllMatches(AbstractGameBoard board);

    /**
     * предусловие: board != null
     * постусловие: result == (найдены ли хотя бы 1 совпадение)
     */
    public abstract boolean hasMatches(AbstractGameBoard board);
}