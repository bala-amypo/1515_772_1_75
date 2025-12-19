package com.example.demo.service.impl;

import com.example.demo.entity.VisitorEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.VisitorService;
import com.example.demo.repository.VisitorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public VisitorEntity createVisitor(VisitorEntity visitor) {

        if (visitor.getPhone() == null || visitor.getPhone().isBlank()) {
            throw new IllegalArgumentException("phone required");
        }

        return visitorRepository.save(visitor);
    }

    @Override
    public VisitorEntity getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }

    @Override
    public List<VisitorEntity> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
