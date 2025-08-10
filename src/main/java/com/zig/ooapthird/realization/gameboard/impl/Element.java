package com.zig.ooapthird.realization.gameboard.impl;

import com.zig.ooapthird.realization.gameboard.AbstractBonus;
import com.zig.ooapthird.realization.gameboard.AbstractElement;

public class Element extends AbstractElement {
    private final char type;
    private final boolean bonus;

    public Element(char type, boolean bonus) {
        this.type = type;
        this.bonus = bonus;
    }

    public char getType() { return type; }
    public boolean isBonus() { return bonus; }

    @Override
    public AbstractBonus getBonus() {
        return null;
    }

    @Override
    public String toString() {
        return bonus ? Character.toString(type).toLowerCase() : Character.toString(type);
    }
}