package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.project.entity.CompleteProduct;
import com.example.project.repo.Cproductorderrepo;

@Service
public class Cproductorder {
    @Autowired
    public Cproductorderrepo corderrepo;

    public void completeOrder(CompleteProduct complete)
    {
        corderrepo.save(complete); 
    }


    public Optional<CompleteProduct> getProductById(int id) {
        return corderrepo.findById(id);
    }

    public List<CompleteProduct>Findall()

    {
        
        return corderrepo.findAll();
        
    }
}
