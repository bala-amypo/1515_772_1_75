package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "risk_rule",
        uniqueConstraints = @UniqueConstraint(columnNames = "ruleName")
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String ruleType;

    private Integer threshold;

    private Integer scoreImpact;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
