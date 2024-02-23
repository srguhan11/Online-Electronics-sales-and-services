package com.example.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.ProductOrder;



@Repository
public interface OrderRepo extends JpaRepository<ProductOrder,Integer> 
{

    List<ProductOrder> findByemail(String id);


    
    
    
}
