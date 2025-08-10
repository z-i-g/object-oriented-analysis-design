package com.zig.ooapthird.realization.ui.impl;

import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.gameboard.Coordinate;
import com.zig.ooapthird.realization.statistic.Move;
import com.zig.ooapthird.realization.ui.AbstractUserInterface;

import java.util.Scanner;

public class UserInterface extends AbstractUserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public void printBoard(AbstractGameBoard board) {
        System.out.println();
        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board.size(); c++) {
                System.out.print(board.getElementAt(r,c) + " ");
            }
            System.out.println();
        }
    }

    public Move promptMove() {
        System.out.print("\nВведите ход (r1 c1 r2 c2): ");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        return new Move(new Coordinate(r1,c1), new Coordinate(r2,c2));
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
