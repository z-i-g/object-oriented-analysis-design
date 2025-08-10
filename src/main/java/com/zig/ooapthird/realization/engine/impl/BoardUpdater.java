package com.zig.ooapthird.realization.engine.impl;

import com.zig.ooapthird.realization.engine.AbstractBoardUpdater;
import com.zig.ooapthird.realization.engine.Combination;
import com.zig.ooapthird.realization.gameboard.AbstractElement;
import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.gameboard.Coordinate;
import com.zig.ooapthird.realization.gameboard.impl.Element;

import java.util.List;
import java.util.Random;

public class BoardUpdater extends AbstractBoardUpdater {
    private static final char[] TYPES = {'A','B','C','D','E'};
    private final Random rnd = new Random();

    public void removeMatches(AbstractGameBoard board, List<Combination> matches) {
        for (Combination comb : matches) {
            for (Coordinate coord : comb.positions()) {
                board.setElementAt(coord.row(), coord.col(), null);
            }
        }
    }

    public void collapseColumns(AbstractGameBoard board) {
        int size = board.size();
        for (int c = 0; c < size; c++) {
            int writeRow = size - 1;
            for (int r = size - 1; r >= 0; r--) {
                AbstractElement e = board.getElementAt(r, c);
                if (e != null) {
                    board.setElementAt(writeRow, c, e);
                    if (writeRow != r) board.setElementAt(r, c, null);
                    writeRow--;
                }
            }
        }
    }

    public void generateNewElements(AbstractGameBoard board) {
        int size = board.size();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board.getElementAt(r, c) == null) {
                    board.setElementAt(r, c, randomElement());
                }
            }
        }
    }

    private AbstractElement randomElement() {
        return new Element(TYPES[rnd.nextInt(TYPES.length)], false);
    }
}