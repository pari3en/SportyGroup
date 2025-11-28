package com.example.jackpot.config;

import com.example.jackpot.model.ContributionType;
import com.example.jackpot.model.Jackpot;
import com.example.jackpot.model.RewardType;
import com.example.jackpot.repository.JackpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final JackpotRepository jackpotRepository;

    @Override
    public void run(String... args) {
        Jackpot j = new Jackpot();
        j.setJackpotId("J1");
        j.setInitialPool(100.0);
        j.setCurrentPool(100.0);
        j.setContributionType(ContributionType.FIXED);
        j.setRewardType(RewardType.VARIABLE);
        j.setFixedContributionPercent(5.0);
        j.setFixedRewardChancePercent(1.0);
        j.setVariableContributionStart(10.0);
        j.setVariableContributionEnd(2.0);
        j.setVariableRewardStart(0.5);
        j.setVariableRewardEnd(50.0);
        j.setRewardLimit(1000.0);
        jackpotRepository.save(j);
    }
}
