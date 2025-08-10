package com.zig.ooapthird.realization.gameboard;

public abstract class AbstractElement {
    private char type;
    private boolean isBonus;
    private AbstractBonus abstractBonus;
    public abstract char getType();
    public abstract boolean isBonus();
    public abstract AbstractBonus getBonus();
}