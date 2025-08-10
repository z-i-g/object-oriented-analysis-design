package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.GameBoard;
import com.zig.ooapthird.realization.statistic.Score;
import com.zig.ooapthird.realization.statistic.StatisticManager;

public abstract class GameEngine {
    private GameBoard board;
    private StatisticManager stats;
    private Score score;

    public abstract void startGame();
    public abstract boolean processMove(Coordinate c1, Coordinate c2); // Ход игрока
    public abstract boolean checkGameOver();
    public abstract void restartGame();
}