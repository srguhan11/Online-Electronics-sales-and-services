package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.ProductOrder;
import com.example.project.repo.OrderRepo;
@Service
public class PorderService {
    
    @Autowired
    private OrderRepo repo;


    public List<ProductOrder>Findall()

    {
        
        return repo.findAll();
        
    }

    public void details(ProductOrder productOrder)
    {
        repo.save(productOrder);
    }

    public void removeProductById(Integer id){
        repo.deleteById( id);
     }

public List<ProductOrder> findbyemail(String id)
{
 return repo.findByemail(id);
}

public Optional<ProductOrder> getProductById(Integer id) {
    return repo.findById(id);
}
}
