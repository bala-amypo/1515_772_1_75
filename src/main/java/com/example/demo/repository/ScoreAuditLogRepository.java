package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ScoreAuditLogEntity;

public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLogEntity, Long> {
}
