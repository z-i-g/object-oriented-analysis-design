package com.zig;

import com.zig.ooapthird.realization.engine.impl.GameEngine;
import com.zig.ooapthird.realization.ui.impl.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        GameEngine engine = new GameEngine(ui);
        engine.startGame();
    }
}