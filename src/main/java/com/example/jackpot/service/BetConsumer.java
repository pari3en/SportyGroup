package com.example.jackpot.service;

import com.example.jackpot.model.Bet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class BetConsumer {
    private final JackpotService jackpotService;

    public void receiveMessage(Bet bet){
        log.info("Consuming bet: {}", bet);
        jackpotService.processBetContribution(bet);
    }
}
