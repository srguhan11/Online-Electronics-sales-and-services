package com.example.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.ServiceOrder;

@Repository
public interface SOrderRepo extends JpaRepository<ServiceOrder,Integer> {

    List<ServiceOrder> findByemail(String id);
    
}
