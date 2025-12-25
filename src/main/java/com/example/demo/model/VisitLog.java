package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.example.demo.model.VisitorEntity;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_log")
public class VisitLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visitor_id")
    private VisitorEntity visitor;

    @Column(nullable = false)
    private LocalDateTime entryTime;

    @Column
    private LocalDateTime exitTime;

    @NotBlank
    @Column(nullable = false)
    private String purpose;

    @NotBlank
    @Column(nullable = false)
    private String location;

    @PrePersist
    public void onCreate() {
        this.entryTime = LocalDateTime.now();
    }

    // Constructors
    public VisitLogEntity() {}

    public VisitLogEntity(String purpose, String location, LocalDateTime exitTime) {
        this.purpose = purpose;
        this.location = location;
        this.exitTime = exitTime;
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

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        if (exitTime != null && exitTime.isBefore(this.entryTime)) {
            throw new IllegalArgumentException("exitTime must be after entryTime");
        }
        this.exitTime = exitTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
