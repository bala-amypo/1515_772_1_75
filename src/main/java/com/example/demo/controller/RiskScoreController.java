package com.example.demo.controller;

import com.example.demo.model.RiskScoreEntity;
import com.example.demo.service.RiskScoreService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    public RiskScoreController(RiskScoreService riskScoreService) {
        this.riskScoreService = riskScoreService;
    }

    // POST /api/risk-scores/evaluate/{visitorId}
    @PostMapping("/evaluate/{visitorId}")
    public ResponseEntity<RiskScoreEntity> evaluateVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(riskScoreService.evaluateVisitor(visitorId));
    }

    // GET /api/risk-scores/{visitorId}
    @GetMapping("/{visitorId}")
    public ResponseEntity<RiskScoreEntity> getScoreForVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(riskScoreService.getScoreForVisitor(visitorId));
    }

    // GET /api/risk-scores
    @GetMapping
    public ResponseEntity<List<RiskScoreEntity>> getAllScores() {
        return ResponseEntity.ok(riskScoreService.getAllScores());
    }
}
