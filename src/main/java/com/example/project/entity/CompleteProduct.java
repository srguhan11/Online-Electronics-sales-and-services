package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "completeProductorder")
public class CompleteProduct {
    @Id
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String zip;
    private String category;
    private String productname; 
    private String price;
    

}
