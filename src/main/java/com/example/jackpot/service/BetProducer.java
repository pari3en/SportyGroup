package com.example.jackpot.service;

import com.example.jackpot.model.Bet;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BetProducer {

    @Value("${spring.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public void publishMessage(Bet bet) {
        log.info("Publishing bet: {}", bet);
        kafkaTemplate.send(topic, bet.getBetId(), mapper.writeValueAsString(bet));
    }
}
