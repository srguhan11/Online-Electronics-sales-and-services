package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="productAdd")
public class Products{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
     private int id;
     private String name;
     @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id", referencedColumnName = "category_id")
     private Category category;
     private double price;
     private String brand;
     private String description;
     private String imageName;
    

}