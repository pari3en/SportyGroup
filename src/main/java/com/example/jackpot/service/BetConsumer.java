package com.example.jackpot.service;

import com.example.jackpot.model.Bet;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class BetConsumer {
    private final JackpotService jackpotService;

    private final ObjectMapper mapper=new ObjectMapper();

    @SneakyThrows
    @KafkaListener(topics="${spring.kafka.topic}", groupId="jackpot-group")
    public void receiveMessage(String message){
        Bet bet = mapper.readValue(message, Bet.class);
        log.info("Consuming bet: {}", bet);
        jackpotService.processBetContribution(bet);
    }

}
