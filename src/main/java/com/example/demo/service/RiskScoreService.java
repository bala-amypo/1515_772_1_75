package com.example.demo.service;

import com.example.demo.entity.RiskScoreEntity;

import java.util.List;

public interface RiskScoreService {

    RiskScoreEntity evaluateVisitor(Long visitorId);

    RiskScoreEntity getScoreForVisitor(Long visitorId);

    List<RiskScore> getAllScores();
}
