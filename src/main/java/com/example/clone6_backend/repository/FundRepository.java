package com.example.clone6_backend.repository;

import com.example.clone6_backend.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FundRepository extends JpaRepository<Fund, Long> {

    Fund findByFundId(Long fundId);
}
