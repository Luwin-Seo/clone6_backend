package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.RewardRequsetDto;
import com.example.clone6_backend.dto.response.RewardResponseDto;
import com.example.clone6_backend.model.Reward;
import com.example.clone6_backend.repository.RewardRepository;
import com.example.clone6_backend.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RewardController {

    private final RewardRepository rewardRepository;

    private final RewardService rewardService;

    @PostMapping("/tset/reward/{}")
    public Reward postReward(@RequestBody RewardRequsetDto requsetDto) {
        return rewardRepository.save(new Reward(requsetDto));
    }

    @GetMapping("/api/fund/{fundId}/rewards")
    public List<RewardResponseDto> getRewards (@PathVariable Long fundId) {
        return rewardService.getRewards(fundId);
    }
}
