package com.example.jackpot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bet {
    @Id
    private String betId;
    private String userId;
    private String jackpotId;
    private double amount;
}
