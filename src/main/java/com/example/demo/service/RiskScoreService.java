package com.example.demo.service;

import com.example.demo.entity.RiskScoreEntity;

import java.util.List;

public interface RiskScoreService {

    RiskScore evaluateVisitor(Long visitorId);

    RiskScore getScoreForVisitor(Long visitorId);

    List<RiskScore> getAllScores();
}
