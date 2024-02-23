package com.example.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.entity.CompleteService;
import com.example.project.repo.Cserviceorderrepo;

@Service
public class Cserviceorder {
    @Autowired
    public Cserviceorderrepo completeServicrepo;

    public void completeserviceOrder(CompleteService  completeService )
    {
        completeServicrepo.save(completeService);
    }
    public List<CompleteService>Findall()

    {
        
        return completeServicrepo.findAll();
        
    }

}
