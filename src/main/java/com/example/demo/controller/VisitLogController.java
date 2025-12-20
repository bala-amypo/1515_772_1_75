package com.example.demo.controller;

import com.example.demo.model.VisitLogEntity;
import com.example.demo.service.VisitLogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    // POST /api/visit-logs/{visitorId}
    @PostMapping("/{visitorId}")
    public ResponseEntity<VisitLogEntity> createVisitLog(
            @PathVariable Long visitorId,
            @RequestBody VisitLogEntity log) {

        return new ResponseEntity<>(
                visitLogService.createVisitLog(visitorId, log),
                HttpStatus.CREATED
        );
    }

    // GET /api/visit-logs/visitor/{visitorId}
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLogEntity>> getLogsByVisitor(
            @PathVariable Long visitorId) {

        return ResponseEntity.ok(
                visitLogService.getLogsByVisitor(visitorId)
        );
    }

    // GET /api/visit-logs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<VisitLogEntity> getLog(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getLog(id));
    }
}
