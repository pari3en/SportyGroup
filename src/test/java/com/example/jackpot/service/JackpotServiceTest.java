package com.example.jackpot.service;

import com.example.jackpot.model.Bet;
import com.example.jackpot.model.Jackpot;
import com.example.jackpot.repository.JackpotContributionRepository;
import com.example.jackpot.repository.JackpotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class JackpotServiceTest {

    @Autowired
    private JackpotRepository jackpotRepository;
    @Autowired
    private JackpotContributionRepository contributionRepository;

    @Test
    void processContribution_createsContributionAndUpdatesPool() {
        JackpotService service = new JackpotService(jackpotRepository, contributionRepository);
        Jackpot j = new Jackpot();
        j.setJackpotId("T1");
        j.setInitialPool(50.0);
        j.setCurrentPool(50.0);
        j.setContributionType(com.example.jackpot.model.ContributionType.FIXED);
        j.setFixedContributionPercent(10.0);
        jackpotRepository.save(j);

        Bet bet = new Bet("B1", "U1", "T1", 100.0);
        service.processBetContribution(bet);

        Jackpot updated = jackpotRepository.findById("T1").get();
        assertEquals(60.0, updated.getCurrentPool(), 1e-6);
        assertEquals(1, contributionRepository.findAll().size());
    }
}
