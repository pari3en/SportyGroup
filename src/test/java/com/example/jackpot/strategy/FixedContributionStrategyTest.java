package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedContributionStrategyTest {
    @Test
    void fixedContribution() {
        Jackpot j = new Jackpot();
        j.setFixedContributionPercent(5.0);
        FixedContributionStrategy s = new FixedContributionStrategy();
        double c = s.calculateContribution(200.0, j);
        assertEquals(10.0, c, 1e-6);
    }
}
