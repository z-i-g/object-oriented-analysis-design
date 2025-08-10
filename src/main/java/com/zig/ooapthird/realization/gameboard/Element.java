package com.zig.ooapthird.realization.gameboard;

import com.zig.ooapthird.realization.gameboard.Bonus;

public abstract class Element {
    private char type; // 'A', 'B', 'C', 'D', 'E'
    private boolean isBonus;
    private Bonus bonus;

    public abstract char getType();
    public abstract boolean isBonus();
    public abstract Bonus getBonus();
}