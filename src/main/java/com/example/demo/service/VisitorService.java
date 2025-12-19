package com.example.demo.service;

import com.example.demo.entity.VisitorEntity;
import java.util.List;

public interface VisitorService {

    Visitor createVisitor(Visitor visitor);

    Visitor getVisitor(Long id);

    List<Visitor> getAllVisitors();
}
