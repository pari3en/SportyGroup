package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;

public interface RewardStrategy {
    boolean isWinner(Jackpot jackpot);
}
