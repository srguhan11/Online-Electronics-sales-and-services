package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.Scategory;

@Repository
public interface Scategoryrepo extends JpaRepository<Scategory,Integer> {
    
}
