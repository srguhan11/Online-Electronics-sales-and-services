package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.Products;
import com.example.project.repo.ProductRepository;

@Service
public class ProductService {
    @Autowired
   private ProductRepository productrepository;
    public List<Products> getAllProduct() {
        return productrepository.findAll();
        
    }

    public void addProduct(Products product){
        productrepository.save(product);
    }
     public void removeProductById(int id){
        productrepository.deleteById( id);
     }
     public Optional<Products> getProductById(int id) {
         return productrepository.findById(id);
     }

     public List<Products> getAllProductsByCategoryId(int id) {
        return productrepository.findAllByCategory_Id(id);
   
    }

 
   
}
