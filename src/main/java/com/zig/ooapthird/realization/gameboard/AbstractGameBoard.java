package com.zig.ooapthird.realization.gameboard;

public abstract class AbstractGameBoard {
    protected AbstractElement[][] board;

    // Запросы
    public abstract AbstractElement getElementAt(int row, int col);

    public abstract int size();

    // Команды
    public abstract boolean swapElements(Coordinate c1, Coordinate c2); // Перестановка только соседних!

    public abstract void setElementAt(int row, int col, AbstractElement element);
}