package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FixedRewardStrategyTest {
    @Test
    void fixedRewardProbability() {
        Jackpot j = new Jackpot();
        j.setFixedRewardChancePercent(100.0);
        FixedRewardStrategy s = new FixedRewardStrategy();
        assertTrue(s.isWinner(j));
    }
}
