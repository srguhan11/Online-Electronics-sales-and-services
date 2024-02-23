package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.ServiceOrder;
import com.example.project.repo.SOrderRepo;

@Service
public class SOrderService {
    @Autowired
    public SOrderRepo repo;
    
    public void sorder(ServiceOrder serviceOrder)
    {
        repo.save(serviceOrder);
    }

    public List<ServiceOrder>Findall()
    {
        return repo.findAll();
    }
    public List<ServiceOrder>Findbyemailid(String id)
    {
        return repo.findByemail(id);
    }

   
    public Optional<ServiceOrder> getProductById(int id) {
        return repo.findById(id);
    }
public void deletebyid(Integer id)

{
repo.deleteById(id);
}
}
