package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.response.RewardResponseDto;
import com.example.clone6_backend.model.Reward;
import com.example.clone6_backend.repository.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final RewardRepository rewardRepository;

    public List<RewardResponseDto> getRewards(Long fundId) {
        List<RewardResponseDto> rewardResponseDtoList = new ArrayList<>();
        List<Reward> rewardList = rewardRepository.findAllByFundId(fundId);
        for (Reward reward : rewardList) {
            rewardResponseDtoList.add(new RewardResponseDto(reward));
        }
        return rewardResponseDtoList;
    }
}
