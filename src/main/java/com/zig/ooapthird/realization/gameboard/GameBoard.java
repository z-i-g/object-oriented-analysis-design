package com.zig.ooapthird.realization.gameboard;

public abstract class GameBoard {
    private Element[][] board;

    // Операции
    public abstract Element getElementAt(int row, int col);
    public abstract boolean swapElements(Coordinate c1, Coordinate c2); // Перестановка только соседних!
    public abstract void setElementAt(int row, int col, Element element);
    public abstract GameBoard clone(); // Копия для анализа/отката

    // Ограничения
    // - Размер фиксирован (8x8)
    // - Перестановка допустима только для соседних элементов
}