package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VisitLogEntity;

import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLogEntity, Long> {

    List<VisitLogEntity> findByVisitorId(Long visitorId);
}
