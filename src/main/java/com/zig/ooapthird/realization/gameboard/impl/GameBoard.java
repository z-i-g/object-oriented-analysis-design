package com.zig.ooapthird.realization.gameboard.impl;

import com.zig.ooapthird.realization.gameboard.AbstractElement;
import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.gameboard.Coordinate;

import java.util.Random;

public class GameBoard extends AbstractGameBoard {
    private static final char[] TYPES = {'A','B','C','D','E'};
    private final Random rnd = new Random();

    public GameBoard() {
        fillBoardWithoutMatches();
    }

    private void fillBoardWithoutMatches() {
        board = new AbstractElement[8][8];
        for (int r = 0; r < size(); r++) {
            for (int c = 0; c < size(); c++) {
                AbstractElement newElement;
                do {
                    newElement = randomElement();
                    board[r][c] = newElement;
                }
                // повторяем генерацию, если создаётся горизонтальная или вертикальная тройка
                while (createsMatchAt(r, c));
            }
        }
    }

    private boolean createsMatchAt(int row, int col) {
        char type = board[row][col].getType();

        // Проверка по горизонтали (2 слева + текущий)
        if (col >= 2 &&
                board[row][col - 1].getType() == type &&
                board[row][col - 2].getType() == type) {
            return true;
        }

        // Проверка по вертикали (2 сверху + текущий)
        if (row >= 2 &&
                board[row - 1][col].getType() == type &&
                board[row - 2][col].getType() == type) {
            return true;
        }

        return false;
    }

    private AbstractElement randomElement() {
        return new Element(TYPES[rnd.nextInt(TYPES.length)], false);
    }

    public AbstractElement getElementAt(int row, int col) {
        return board[row][col];
    }

    public boolean swapElements(Coordinate c1, Coordinate c2) {
        AbstractElement tmp = board[c1.row()][c1.col()];
        board[c1.row()][c1.col()] = board[c2.row()][c2.col()];
        board[c2.row()][c2.col()] = tmp;
        return true;
    }

    public void setElementAt(int row, int col, AbstractElement element) {
        board[row][col] = element;
    }

    public int size() {
        return board.length;
    }
}
