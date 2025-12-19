package com.example.demo.service;

import com.example.demo.entity.VisitLogEntity;

import java.util.List;

public interface VisitLogService {

    VisitLogEntity createVisitLog(Long visitorId, VisitLogEntity log);

    VisitLogEntity getLog(Long id);

    List<VisitLogEntity> getLogsByVisitor(Long visitorId);
}
