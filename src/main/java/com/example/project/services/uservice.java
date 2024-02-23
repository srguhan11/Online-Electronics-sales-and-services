package com.example.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.usersign;
import com.example.project.repo.userrepository;


@Service
public class uservice{
    @Autowired
private userrepository repo;

    public void userregister(usersign user)
    {
        repo.save(user);
    }

    public List<usersign>Findall()

    {
        
        return repo.findAll();
        
    }
}
