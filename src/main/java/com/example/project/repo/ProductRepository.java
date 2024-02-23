package com.example.project.repo;

import com.example.project.entity.*;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer>{

    List<Products> findAllByCategory_Id(int id);

  

  

  
    
}