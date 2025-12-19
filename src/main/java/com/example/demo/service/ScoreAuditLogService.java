package com.example.demo.service;

import com.example.demo.entity.ScoreAuditLog;
import java.util.List;

public interface ScoreAuditLogService {

    ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log);

    List<ScoreAuditLog> getLogsByVisitor(Long visitorId);

    ScoreAuditLog getLog(Long id);
}
