package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    @Query("""
        select v from VisitLog v
        where v.visitor.id = :visitorId
        and v.entryTime >= :since
    """)
    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    @Query("""
        select count(v) from VisitLog v
        where v.visitor.id = :visitorId
        and v.entryTime between :start and :end
    """)
    long countVisitsInWindow(Long visitorId, LocalDateTime start, LocalDateTime end);
}
