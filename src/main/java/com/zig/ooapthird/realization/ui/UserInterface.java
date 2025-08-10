package com.zig.ooapthird.realization.ui;

import com.zig.ooapthird.realization.gameboard.GameBoard;

public abstract class UserInterface {
    public abstract void printBoard(GameBoard board);
    public abstract Move promptMove();
    public abstract void showMessage(String message);
}