package com.example.demo.controller;

import com.example.demo.entity.RiskRuleEntity;
import com.example.demo.service.RiskRuleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    // POST /api/risk-rules
    @PostMapping
    public ResponseEntity<RiskRuleEntity> createRule(@RequestBody RiskRuleEntity rule) {
        return new ResponseEntity<>(riskRuleService.createRule(rule), HttpStatus.CREATED);
    }

    // GET /api/risk-rules
    @GetMapping
    public ResponseEntity<List<RiskRule>> getAllRules() {
        return ResponseEntity.ok(riskRuleService.getAllRules());
    }

    // GET /api/risk-rules/{id}
    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(riskRuleService.getRule(id));
    }
}
