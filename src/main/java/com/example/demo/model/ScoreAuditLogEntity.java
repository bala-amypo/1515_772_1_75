package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import com.example.demo.model.VisitorEntity;
import com.example.demo.model.RiskRuleEntity;
import java.time.LocalDateTime;

@Entity
@Table(name = "score_audit_log")
public class ScoreAuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visitor_id")
    private VisitorEntity visitor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "risk_rule_id")
    private RiskRuleEntity appliedRule;

    @PositiveOrZero(message = "scoreChange must be >= 0")
    @Column(nullable = false)
    private Integer scoreChange;

    @NotBlank(message = "reason required")
    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    // Constructors
    public ScoreAuditLogEntity() {
    }

    public ScoreAuditLogEntity(VisitorEntity visitor, RiskRuleEntity appliedRule, Integer scoreChange, String reason) {
        this.visitor = visitor;
        this.appliedRule = appliedRule;
        this.scoreChange = scoreChange;
        this.reason = reason;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public VisitorEntity getVisitor() {
        return visitor;
    }

    public void setVisitor(VisitorEntity visitor) {
        this.visitor = visitor;
    }

    public RiskRuleEntity getAppliedRule() {
        return appliedRule;
    }

    public void setAppliedRule(RiskRuleEntity appliedRule) {
        this.appliedRule = appliedRule;
    }

    public Integer getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(Integer scoreChange) {
        this.scoreChange = scoreChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}
