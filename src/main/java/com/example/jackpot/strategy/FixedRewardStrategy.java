package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;

public class FixedRewardStrategy implements RewardStrategy {
    @Override
    public boolean isWinner(Jackpot jackpot) {
        return Math.random() * 100 < jackpot.getFixedRewardChancePercent();
    }
}
