package com.example.project.repo;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.entity.ServiceEntity;

@Repository
public interface Servicerepo  extends JpaRepository<ServiceEntity,Integer>{
    
}
