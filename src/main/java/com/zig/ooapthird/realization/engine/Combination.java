package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.BonusType;
import com.zig.ooapthird.realization.gameboard.Coordinate;

import java.util.List;

public record Combination(List<Coordinate> positions, BonusType bonusType, int size) {}