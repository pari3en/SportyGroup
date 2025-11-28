
package com.example.jackpot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rewards")
@Data
@RequiredArgsConstructor
public class JackpotReward {
    @Id
    @GeneratedValue
    private Long id;
    private final String betId;
    private final String userId;
    private final String jackpotId;
    private final double rewardAmount;
    private final LocalDateTime createdAt;
}
