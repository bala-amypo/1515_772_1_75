package com.example.demo.service;

import com.example.demo.entity.ScoreAuditLogEntity;
import java.util.List;

public interface ScoreAuditLogService {

    ScoreAuditLogEntity logScoreChange(Long visitorId, Long ruleId, ScoreAuditLogEntity log);

    List<ScoreAuditLogEntity> getLogsByVisitor(Long visitorId);

    ScoreAuditLogEntity getLog(Long id);
}
