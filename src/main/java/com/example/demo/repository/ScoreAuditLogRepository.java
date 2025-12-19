package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ScoreAuditLog;

public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {
}
