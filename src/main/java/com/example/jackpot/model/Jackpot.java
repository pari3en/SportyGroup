package com.example.jackpot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "jackpots")
@Data
public class Jackpot {
    @Id
    private String jackpotId;
    private double currentPool;
    private double initialPool;

    @Enumerated(EnumType.STRING)
    private ContributionType contributionType;
    @Enumerated(EnumType.STRING)
    private RewardType rewardType;

    private double fixedContributionPercent;
    private double fixedRewardChancePercent;

    private double variableContributionStart;
    private double variableContributionEnd;
    private double variableRewardStart;
    private double variableRewardEnd;

    private double rewardLimit;
}
