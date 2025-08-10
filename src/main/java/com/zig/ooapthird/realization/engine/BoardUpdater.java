package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.GameBoard;

public abstract class BoardUpdater {
    // запросы
    /**
     * предусловие: board != null && matches != null
     * постусловие: все элементы в matches удалены с board (заменены на пустые)
     */
    public abstract void removeMatches(GameBoard board, List<Combination> matches);

    /**
     * предусловие: board != null
     * постусловие: элементы поля смещены вниз, пустые позиции сверху
     */
    public abstract void collapseColumns(GameBoard board);

    /**
     * предусловие: board != null
     * постусловие: все пустые клетки заменены новыми элементами
     */
    public abstract void generateNewElements(GameBoard board);
}