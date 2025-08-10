package com.zig.ooapthird.realization.engine.impl;

import com.zig.ooapthird.realization.engine.AbstractBoardUpdater;
import com.zig.ooapthird.realization.engine.AbstractCombinationDetector;
import com.zig.ooapthird.realization.engine.Combination;
import com.zig.ooapthird.realization.gameboard.AbstractGameBoard;
import com.zig.ooapthird.realization.gameboard.impl.GameBoard;
import com.zig.ooapthird.realization.statistic.Score;
import com.zig.ooapthird.realization.statistic.impl.StatisticManager;
import com.zig.ooapthird.realization.ui.impl.UserInterface;

import java.util.List;

public class GameEngine {
    private final AbstractGameBoard board;
    private final UserInterface ui;
    private final AbstractCombinationDetector combDetector = new CombinationDetector();
    private final AbstractBoardUpdater boardUpdater = new BoardUpdater();
    private final StatisticManager stats;
    private final Score score;

    public GameEngine(UserInterface ui) {
        this.ui = ui;
        this.board = new GameBoard();
        this.stats = new StatisticManager();
        this.score = new Score();
    }

    public void startGame() {
        boolean running = true;

        while (running) {
            ui.printBoard(board);
            var move = ui.promptMove();
            board.swapElements(move.from(), move.to());

            // ➡ После хода проверить и удалить комбинации
            processMatches();

            ui.showMessage("Ход выполнен!");
        }
    }

    private void processMatches() {
        List<Combination> matches;
        do {
            matches = combDetector.findAllMatches(board);
            if (!matches.isEmpty()) {
                score.addPoints(matches.size() * 30); // пока просто фиксированные очки
                boardUpdater.removeMatches(board, matches);
                boardUpdater.collapseColumns(board);
                boardUpdater.generateNewElements(board);
            }
        } while (!matches.isEmpty());
    }
}