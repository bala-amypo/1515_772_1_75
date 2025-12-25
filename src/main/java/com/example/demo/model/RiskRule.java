package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "risk_rule",
    uniqueConstraints = @UniqueConstraint(columnNames = "rule_name")
)
public class RiskRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_name", nullable = false, unique = true)
    private String ruleName;

    @Column(nullable = false)
    private String ruleType; 
    // AFTER_HOURS / FREQUENT_VISITS / BLACKLIST / KEYWORD / CUSTOM

    @PositiveOrZero
    @Column(nullable = false)
    private Integer threshold;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer scoreImpact;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public RiskRuleEntity() {}

    public RiskRuleEntity(String ruleName, String ruleType, Integer threshold, Integer scoreImpact) {
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.threshold = threshold;
        this.scoreImpact = scoreImpact;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getScoreImpact() {
        return scoreImpact;
    }

    public void setScoreImpact(Integer scoreImpact) {
        this.scoreImpact = scoreImpact;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
