package com.zig.ooapthird.realization.engine;

import com.zig.ooapthird.realization.gameboard.Bonus;

public abstract class BonusFactory {
    // запрос
    /**
     * предусловие: comb != null и comb удовлетворяет условию получения бонуса
     * постусловие: result != null && result.getBonusType() соответствует комбинации comb
     */
    public Bonus createBonus(Combination comb);
}