package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.AbstractBonus;
import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.gameboard.BonusType;
import com.zig.ooapthird.realization.gameboard.Coordinate;

public class Bonus extends AbstractBonus {
    @Override
    public BonusType getBonusType() {
        return null;
    }

    @Override
    public void activate(AbstractGameBoard board, Coordinate position) {}
}