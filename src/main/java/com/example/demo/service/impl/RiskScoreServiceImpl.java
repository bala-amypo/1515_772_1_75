package com.example.demo.service.impl;

import com.example.demo.model.RiskScoreEntity;
import com.example.demo.model.VisitorEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;

    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public RiskScoreEntity evaluateVisitor(Long visitorId) {

        VisitorEntity visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        // ✅ TEMP SCORE (no utils, no visitor score)
        int totalScore = 0;
        String riskLevel = "LOW";

        RiskScoreEntity riskScore = riskScoreRepository
                .findByVisitorId(visitorId)
                .orElse(new RiskScoreEntity());

        riskScore.setVisitor(visitor);
        riskScore.setTotalScore(totalScore);
        riskScore.setRiskLevel(riskLevel);

        return riskScoreRepository.save(riskScore);
    }

    @Override
    public RiskScoreEntity getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("RiskScore not found"));
    }

    @Override
    public List<RiskScoreEntity> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
