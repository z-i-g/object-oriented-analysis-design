package com.zig.ooapthird.realization.engine.impl;

import com.zig.ooapthird.realization.engine.AbstractCombinationDetector;
import com.zig.ooapthird.realization.engine.Combination;
import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.gameboard.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CombinationDetector extends AbstractCombinationDetector {
    public List<Combination> findAllMatches(AbstractGameBoard board) {
        List<Combination> matches = new ArrayList<>();
        int size = board.size();

        // Горизонтально
        for (int r = 0; r < size; r++) {
            int count = 1;
            for (int c = 1; c < size; c++) {
                if (board.getElementAt(r, c).getType() == board.getElementAt(r, c - 1).getType()) {
                    count++;
                } else {
                    if (count >= 3) {
                        matches.add(makeCombinationRow(r, c - count, count));
                    }
                    count = 1;
                }
            }
            if (count >= 3) {
                matches.add(makeCombinationRow(r, size - count, count));
            }
        }

        // Вертикально
        for (int c = 0; c < size; c++) {
            int count = 1;
            for (int r = 1; r < size; r++) {
                if (board.getElementAt(r, c).getType() == board.getElementAt(r - 1, c).getType()) {
                    count++;
                } else {
                    if (count >= 3) {
                        matches.add(makeCombinationCol(c, r - count, count));
                    }
                    count = 1;
                }
            }
            if (count >= 3) {
                matches.add(makeCombinationCol(c, size - count, count));
            }
        }

        return matches;
    }

    private Combination makeCombinationRow(int row, int startCol, int length) {
        List<Coordinate> coords = new ArrayList<>();
        for (int i = 0; i < length; i++) coords.add(new Coordinate(row, startCol + i));
        return new Combination(coords, null, length);
    }

    private Combination makeCombinationCol(int col, int startRow, int length) {
        List<Coordinate> coords = new ArrayList<>();
        for (int i = 0; i < length; i++) coords.add(new Coordinate(startRow + i, col));
        return new Combination(coords, null, length);
    }

    public boolean hasMatches(AbstractGameBoard board) {
        return !findAllMatches(board).isEmpty();
    }
}