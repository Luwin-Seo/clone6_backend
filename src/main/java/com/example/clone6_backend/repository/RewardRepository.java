package com.example.clone6_backend.repository;

import com.example.clone6_backend.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RewardRepository extends JpaRepository<Reward, Long> {
    List<Reward> findAllByFundId(Long fundId);
    Reward findByRewardId(Long rewardId);
}
