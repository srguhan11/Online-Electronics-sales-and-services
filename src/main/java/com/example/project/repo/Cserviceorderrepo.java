package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.CompleteService;

@Repository
public interface Cserviceorderrepo extends JpaRepository<CompleteService,Integer> {
    
}
