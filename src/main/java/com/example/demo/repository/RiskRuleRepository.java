package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.RiskRuleEntity;

import java.util.Optional;

public interface RiskRuleRepository extends JpaRepository<RiskRuleEntity, Long> {

    Optional<RiskRuleEntity> findByRuleName(String ruleName);
}
