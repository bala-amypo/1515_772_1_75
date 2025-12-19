package com.example.demo.controller;

import com.example.demo.entity.VisitorEntity;
import com.example.demo.service.VisitorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    // POST /api/visitors
    @PostMapping
    public ResponseEntity<VisitorEntity> createVisitor(@RequestBody VisitorEntity visitor) {
        return new ResponseEntity<>(
                visitorService.createVisitor(visitor),
                HttpStatus.CREATED
        );
    }

    // GET /api/visitors
    @GetMapping
    public ResponseEntity<List<VisitorEntity>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }

    // GET /api/visitors/{id}
    @GetMapping("/{id}")
    public ResponseEntity<VisitorEntity> getVisitor(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.getVisitor(id));
    }
}
