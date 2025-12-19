package com.example.demo.controller;

import com.example.demo.entity.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    public ScoreAuditLogController(ScoreAuditLogService scoreAuditLogService) {
        this.scoreAuditLogService = scoreAuditLogService;
    }

    // POST /api/score-logs/{visitorId}/{ruleId}
    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> createAuditLog(
            @PathVariable Long visitorId,
            @PathVariable Long ruleId,
            @RequestBody ScoreAuditLog log) {

        ScoreAuditLog savedLog =
                scoreAuditLogService.logScoreChange(visitorId, ruleId, log);

        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }

    // GET /api/score-logs/visitor/{visitorId}
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> getLogsByVisitor(
            @PathVariable Long visitorId) {

        List<ScoreAuditLog> logs =
                scoreAuditLogService.getLogsByVisitor(visitorId);

        return ResponseEntity.ok(logs);
    }

    // GET /api/score-logs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> getLogById(@PathVariable Long id) {

        ScoreAuditLog log = scoreAuditLogService.getLog(id);

        return ResponseEntity.ok(log);
    }
}
