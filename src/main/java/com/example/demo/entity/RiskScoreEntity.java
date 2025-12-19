package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

@Entity
@Table(name = "risk_score")
public class RiskScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer totalScore;

    @Column(nullable = false)
    private String riskLevel; // LOW / MEDIUM / HIGH / CRITICAL

    @Column(nullable = false)
    private LocalDateTime evaluatedAt;

    @PrePersist
    public void onCreate() {
        this.evaluatedAt = LocalDateTime.now();
    }

    public RiskScoreEntity() {}

    public RiskScoreEntity(Visitor visitor, Integer totalScore, String riskLevel) {
        this.visitor = visitor;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
