package com.example.demo.service;

import com.example.demo.model.VisitorEntity;
import java.util.List;

public interface VisitorService {

    VisitorEntity createVisitor(VisitorEntity visitor);

    VisitorEntity getVisitor(Long id);

    List<VisitorEntity> getAllVisitors();
}
