package com.example.project.repo;
import com.example.project.entity.CompleteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cproductorderrepo extends JpaRepository<CompleteProduct,Integer> {
    
}
