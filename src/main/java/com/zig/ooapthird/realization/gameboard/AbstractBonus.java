package com.zig.ooapthird.realization.gameboard;

public abstract class AbstractBonus {
    public abstract BonusType getBonusType();
    public abstract void activate(AbstractGameBoard board, Coordinate position);
}