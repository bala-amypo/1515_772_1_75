package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
@Tag(name = "Risk Rules")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    // Constructor injection (MANDATORY for tests)
    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    @PostMapping
    public ResponseEntity<RiskRule> create(@RequestBody RiskRule rule) {
        return ResponseEntity.ok(riskRuleService.createRule(rule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> get(@PathVariable Long id) {
        return ResponseEntity.ok(riskRuleService.getRule(id));
    }

    // 🔑 IMPORTANT: tests expect method name "all()"
    @GetMapping
    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(riskRuleService.getAllRules());
    }
}
