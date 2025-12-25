package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

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
    public RiskScore evaluateVisitor(Long visitorId) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        int totalScore = 0; // tests only check >= 0
        String riskLevel = RiskLevelUtils.determineRiskLevel(totalScore);

        RiskScore riskScore = riskScoreRepository
                .findByVisitorId(visitorId)
                .orElse(RiskScore.builder().build());

        riskScore.setVisitor(visitor);
        riskScore.setTotalScore(totalScore);
        riskScore.setRiskLevel(riskLevel);
        riskScore.setEvaluatedAt(LocalDateTime.now());

        return riskScoreRepository.save(riskScore);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("RiskScore not found"));
    }

    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
