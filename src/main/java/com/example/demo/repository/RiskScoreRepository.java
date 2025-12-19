package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RiskScoreEntity;

import java.util.Optional;

public interface RiskScoreRepository extends JpaRepository<RiskScoreEntity, Long> {

    Optional<RiskScore> findByVisitorId(Long visitorId);
}
    