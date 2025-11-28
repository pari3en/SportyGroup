package com.example.jackpot.service;

import com.example.jackpot.model.Bet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BetProducer {
    public void publishMessage(Bet bet) {
        log.info("Publishing bet: {}", bet);
    }
}
