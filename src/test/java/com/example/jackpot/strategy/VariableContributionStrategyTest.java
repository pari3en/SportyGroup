package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VariableContributionStrategyTest {
    @Test
    void variableContributionBounds() {
        Jackpot j = new Jackpot();
        j.setVariableContributionStart(10.0);
        j.setVariableContributionEnd(2.0);
        j.setCurrentPool(0.0);
        VariableContributionStrategy s = new VariableContributionStrategy();
        double c1 = s.calculateContribution(100.0, j);
        assertTrue(c1 >= 2.0 && c1 <= 10.0);
        j.setCurrentPool(100000.0);
        double c2 = s.calculateContribution(100.0, j);
        assertEquals(2.0, c2, 1e-6);
    }
}
