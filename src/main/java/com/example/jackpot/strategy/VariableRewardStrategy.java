package com.example.jackpot.strategy;

import com.example.jackpot.model.Jackpot;

public class VariableRewardStrategy implements RewardStrategy {
    @Override
    public boolean isWinner(Jackpot jackpot) {
        double percent = jackpot.getVariableRewardStart();
        double pool = jackpot.getCurrentPool();
        double deltaVariableReward = jackpot.getVariableRewardEnd() - jackpot.getVariableRewardStart();
        percent += Math.min(pool / 10000.0 * deltaVariableReward, deltaVariableReward);
        if (pool >= jackpot.getRewardLimit()) percent = 100.0;
        percent = Math.min(percent, jackpot.getVariableRewardEnd());
        return Math.random() * 100 < percent;
    }
}
