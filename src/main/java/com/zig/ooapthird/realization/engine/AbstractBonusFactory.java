package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.AbstractBonus;

public abstract class AbstractBonusFactory {
    // запрос
    /**
     * предусловие: comb != null и comb удовлетворяет условию получения бонуса
     * постусловие: result != null && result.getBonusType() соответствует комбинации comb
     */
    public abstract AbstractBonus createBonus(Combination comb);
}