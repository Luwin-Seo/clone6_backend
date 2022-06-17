package com.example.clone6_backend.repository;

import com.example.clone6_backend.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FundRepository extends JpaRepository<Fund, Long> {

    List<Fund> findAllByOrderCreateByDesc();
}
