package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.RiskScoreEntity;

import java.util.Optional;

public interface RiskScoreRepository extends JpaRepository<RiskScoreEntity, Long> {

    Optional<RiskScoreEntity> findByVisitorId(Long visitorId);
}
    