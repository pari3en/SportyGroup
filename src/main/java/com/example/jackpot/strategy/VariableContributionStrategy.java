package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;

public class VariableContributionStrategy implements ContributionStrategy {
    @Override
    public double calculateContribution(double betAmount, Jackpot jackpot) {
        double start = jackpot.getVariableContributionStart();
        double end = jackpot.getVariableContributionEnd();
        double pool = jackpot.getCurrentPool();
        double factor = Math.min(pool / 10000.0, 1.0);
        double percent = start - (start - end) * factor;
        percent = Math.max(percent, end);
        return betAmount * percent / 100.0;
    }
}
