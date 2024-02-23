package com.example.project.services;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.Category;
import com.example.project.repo.Catrepo;

@Service
public class Catser {
    @Autowired
    Catrepo repo;
     public List<Category>getAllCategory()
     {
        return repo.findAll();
     }
    public void addcat(Category cat)
    { 
        repo.save(cat);
    }

    public void removecat(int id)
    {
        repo.deleteById(id);
    }
    public Optional<Category> findbyid(int id)
    {
      return  repo.findById(id);
    }
     
    
}
