package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;

public interface ContributionStrategy {
    double calculateContribution(double betAmount, Jackpot jackpot);
}
