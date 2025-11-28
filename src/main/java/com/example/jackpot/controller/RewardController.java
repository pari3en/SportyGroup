package com.example.jackpot.controller;

import com.example.jackpot.model.JackpotReward;
import com.example.jackpot.repository.BetRepository;
import com.example.jackpot.service.RewardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rewards")
@AllArgsConstructor
public class RewardController {
    private final RewardService rewardService;
    private final BetRepository betRepository;

    @GetMapping("/{betId}")
    public ResponseEntity<?> evaluate(@PathVariable String betId) {
        return betRepository.findById(betId).map(bet -> {
            JackpotReward jackpotReward = rewardService.evaluateReward(bet);
            return jackpotReward != null ? ResponseEntity.ok(jackpotReward) : ResponseEntity.ok("Sorry, no reward");
        }).orElse(ResponseEntity.notFound().build());
    }
}
