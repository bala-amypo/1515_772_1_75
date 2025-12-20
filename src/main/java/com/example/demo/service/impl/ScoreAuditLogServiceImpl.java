package com.example.demo.service.impl;

import com.example.demo.model.ScoreAuditLogEntity;
import com.example.demo.model.VisitorEntity;
import com.example.demo.model.RiskRuleEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.ScoreAuditLogService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final ScoreAuditLogRepository scoreAuditLogRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository riskRuleRepository;

    public ScoreAuditLogServiceImpl(
            ScoreAuditLogRepository scoreAuditLogRepository,
            VisitorRepository visitorRepository,
            RiskRuleRepository riskRuleRepository) {
        this.scoreAuditLogRepository = scoreAuditLogRepository;
        this.visitorRepository = visitorRepository;
        this.riskRuleRepository = riskRuleRepository;
    }

    @Override
    public ScoreAuditLogEntity logScoreChange(Long visitorId, Long ruleId, ScoreAuditLogEntity log) {

        VisitorEntity visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        RiskRuleEntity rule = riskRuleRepository.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));

        log.setVisitor(visitor);
        log.setAppliedRule(rule);

        return scoreAuditLogRepository.save(log);
    }

    @Override
    public List<ScoreAuditLogEntity> getLogsByVisitor(Long visitorId) {
        return scoreAuditLogRepository.findAll()
                .stream()
                .filter(log -> log.getVisitor().getId().equals(visitorId))
                .toList();
    }

    @Override
    public ScoreAuditLogEntity getLog(Long id) {
        return scoreAuditLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ScoreAuditLog not found"));
    }
}
