package com.example.project.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.Scategory;
import com.example.project.repo.Scategoryrepo;

@Service
public class Scat {
    @Autowired
    public  Scategoryrepo repo;

    public void scategory(Scategory scategory )
    {
        repo.save(scategory);
       
    }

    public List<Scategory>getAllSCategory()
    {
       return repo.findAll();
    }
    public void removecat(int id)
    {
        repo.deleteById(id);
    }

    public Optional<Scategory> findbyid(int id)
    {
      return  repo.findById(id);
    }
    
}
