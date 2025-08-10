package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.gameboard.Coordinate;
import com.zig.ooapthird.realization.statistic.AbstractScore;
import com.zig.ooapthird.realization.statistic.AbstractStatisticManager;

public abstract class AbstractGameEngine {
    private AbstractGameBoard board;
    private AbstractStatisticManager stats;
    private AbstractScore score;

    public abstract void startGame();
    public abstract boolean processMove(Coordinate c1, Coordinate c2); // Ход игрока
    public abstract boolean checkGameOver();
    public abstract void restartGame();
}