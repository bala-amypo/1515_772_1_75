package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ScoreAuditLogEntity;

public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {
}
