package com.example.demo.service.impl;

import com.example.demo.entity.RiskScoreEntity;
import com.example.demo.entity.VisitorEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        // 1️⃣ Get visitor
        VisitorEntity visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        // 2️⃣ For now assume score is calculated elsewhere
        // (later this can be derived from VisitLogs + RiskRules)
        int totalScore = 0;

        // 3️⃣ Determine risk level using utility class
        String riskLevel = RiskLevelUtils.determineRiskLevel(totalScore);

        // 4️⃣ Check if risk score already exists for visitor
        RiskScoreEntity riskScore = riskScoreRepository
                .findByVisitorId(visitorId)
                .orElse(new RiskScoreEntity());

        // 5️⃣ Set values
        riskScore.setVisitor(visitor);
        riskScore.setTotalScore(totalScore);
        riskScore.setRiskLevel(riskLevel);
        riskScore.setEvaluatedAt(LocalDateTime.now());

        // 6️⃣ Save & return
        return riskScoreRepository.save(riskScore);
    }

    @Override
    public RiskScoreEntity getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk score not found"));
    }

    @Override
    public List<RiskScoreEntity> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
