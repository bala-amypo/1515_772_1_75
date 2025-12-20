package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VisitorEntity;

public interface VisitorRepository extends JpaRepository<VisitorEntity, Long> {
}
