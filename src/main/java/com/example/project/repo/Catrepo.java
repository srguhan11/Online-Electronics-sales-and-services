package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.Category;

@Repository
public interface Catrepo extends  JpaRepository<Category,Integer>{
    
}
