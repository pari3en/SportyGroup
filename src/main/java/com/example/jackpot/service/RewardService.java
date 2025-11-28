package com.example.jackpot.service;

import com.example.jackpot.model.Bet;
import com.example.jackpot.model.JackpotReward;
import com.example.jackpot.repository.JackpotRepository;
import com.example.jackpot.repository.JackpotRewardRepository;
import com.example.jackpot.strategy.FixedRewardStrategy;
import com.example.jackpot.strategy.RewardStrategy;
import com.example.jackpot.strategy.VariableRewardStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class RewardService {
    private final JackpotRepository jackpotRepository;
    private final JackpotRewardRepository rewardRepository;

    @Transactional
    public JackpotReward evaluateReward(Bet bet) {
        return jackpotRepository.findById(bet.getJackpotId()).map(jackpot -> {
            RewardStrategy strat = switch (jackpot.getRewardType()) {
                case FIXED -> new FixedRewardStrategy();
                case VARIABLE -> new VariableRewardStrategy();
            };

            boolean winner = strat.isWinner(jackpot);
            if (!winner) {
                log.info("Sorry, no reward");
                return null;
            }

            double rewardAmt = jackpot.getCurrentPool();
            JackpotReward jackpotReward = new JackpotReward(bet.getBetId(), bet.getUserId(), bet.getJackpotId(), rewardAmt, LocalDateTime.now());
            rewardRepository.save(jackpotReward);
            log.info("Reward is {}", jackpotReward);

            jackpot.setCurrentPool(jackpot.getInitialPool());
            jackpotRepository.save(jackpot);
            return jackpotReward;

        }).orElse(null);
    }
}
