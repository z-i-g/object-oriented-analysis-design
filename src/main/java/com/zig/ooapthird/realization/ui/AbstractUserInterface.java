package com.zig.ooapthird.realization.ui;

import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.statistic.Move;

public abstract class AbstractUserInterface {
    public abstract void printBoard(AbstractGameBoard board);
    public abstract Move promptMove();
    public abstract void showMessage(String message);
}