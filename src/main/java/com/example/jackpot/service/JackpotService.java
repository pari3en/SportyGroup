package com.example.jackpot.service;

import com.example.jackpot.model.Bet;
import com.example.jackpot.model.JackpotContribution;
import com.example.jackpot.repository.JackpotContributionRepository;
import com.example.jackpot.repository.JackpotRepository;
import com.example.jackpot.strategy.ContributionStrategy;
import com.example.jackpot.strategy.FixedContributionStrategy;
import com.example.jackpot.strategy.VariableContributionStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class JackpotService {
    private final JackpotRepository jackpotRepository;
    private final JackpotContributionRepository contributionRepository;

    @Transactional
    public void processBetContribution(Bet bet) {
        jackpotRepository.findById(bet.getJackpotId()).ifPresent(jackpot -> {
            ContributionStrategy strat = switch (jackpot.getContributionType()) {
                case FIXED -> new FixedContributionStrategy();
                case VARIABLE -> new VariableContributionStrategy();
            };

            double contribution = strat.calculateContribution(bet.getAmount(), jackpot);
            double newPool = jackpot.getCurrentPool() + contribution;
            jackpot.setCurrentPool(newPool);
            jackpotRepository.save(jackpot);

            JackpotContribution jc = new JackpotContribution(bet.getBetId(), bet.getUserId(), bet.getJackpotId(), bet.getAmount(), contribution, newPool, LocalDateTime.now());
            contributionRepository.save(jc);
        });
    }
}
