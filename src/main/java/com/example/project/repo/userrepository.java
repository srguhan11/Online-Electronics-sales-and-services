package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.usersign;
@Repository
public interface userrepository extends JpaRepository<usersign,String>  {
 
    
}
