package com.example.demo.service.impl;

import com.example.demo.entity.RiskRuleEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository riskRuleRepository;

    public RiskRuleServiceImpl(RiskRuleRepository riskRuleRepository) {
        this.riskRuleRepository = riskRuleRepository;
    }

    @Override
    public RiskRuleEntity createRule(RiskRuleEntity rule) {

        if (riskRuleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Rule name must be unique");
        }

        return riskRuleRepository.save(rule);
    }

    @Override
    public List<RiskRuleEntity> getAllRules() {
        return riskRuleRepository.findAll();
    }

    @Override
    public RiskRuleEntity getRule(Long id) {
        return riskRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));
    }
}
