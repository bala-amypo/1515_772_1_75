package com.example.demo.service.impl;

import com.example.demo.entity.VisitLogEntity;
import com.example.demo.entity.VisitorEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitLogService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private final VisitLogRepository visitLogRepository;
    private final VisitorRepository visitorRepository;

    public VisitLogServiceImpl(VisitLogRepository visitLogRepository,
                               VisitorRepository visitorRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public VisitLogEntity createVisitLog(Long visitorId, VisitLogEntity log) {

        VisitorEntity visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        log.setVisitor(visitor);

        return visitLogRepository.save(log);
    }

    @Override
    public VisitLogEntity getLog(Long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));
    }

    @Override
    public List<VisitLogEntity> getLogsByVisitor(Long visitorId) {
        return visitLogRepository.findByVisitorId(visitorId);
    }
}
