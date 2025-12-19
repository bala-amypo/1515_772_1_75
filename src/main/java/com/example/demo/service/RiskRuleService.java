package com.example.demo.service;

import com.example.demo.entity.RiskRuleEntity;
import java.util.List;

public interface RiskRuleService {

    RiskRuleEntity createRule(RiskRuleEntity rule);

    List<RiskRuleEntity> getAllRules();

    RiskRuleEntity getRule(Long id);
}
