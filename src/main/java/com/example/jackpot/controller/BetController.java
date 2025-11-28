package com.example.jackpot.controller;

import com.example.jackpot.model.Bet;
import com.example.jackpot.repository.BetRepository;
import com.example.jackpot.service.BetProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bets")
@AllArgsConstructor
public class BetController {
    private final BetProducer producer;
    private final BetRepository betRepository;

    @PostMapping
    public ResponseEntity<?> publishBet(@RequestBody Bet bet) {
        // persist bet
        betRepository.save(bet);
        // publish to kafka
        producer.publishMessage(bet);
        return ResponseEntity.ok("Bet published");
    }
}
