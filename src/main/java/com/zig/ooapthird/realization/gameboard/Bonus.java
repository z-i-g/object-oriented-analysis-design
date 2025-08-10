package com.zig.ooapthird.realization.gameboard;

import com.zig.ooapthird.realization.gameboard.GameBoard;

public abstract class Bonus {
    public abstract BonusType getBonusType(); // Тип бонуса
    public abstract void activate(GameBoard board, Coordinate position);
}