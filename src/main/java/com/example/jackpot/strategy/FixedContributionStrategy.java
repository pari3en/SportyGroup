package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;

public class FixedContributionStrategy implements ContributionStrategy {
    @Override
    public double calculateContribution(double betAmount, Jackpot jackpot) {
        return betAmount * jackpot.getFixedContributionPercent() / 100.0;
    }
}
