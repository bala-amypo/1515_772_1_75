package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "risk_score")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Visitor visitor;

    private Integer totalScore;

    private String riskLevel;

    private LocalDateTime evaluatedAt;

    @PrePersist
    public void prePersist() {
        this.evaluatedAt = LocalDateTime.now();
    }
}
