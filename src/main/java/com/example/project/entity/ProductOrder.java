package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="productOrder")
public class ProductOrder {
    
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private int id;
    private String name;


    private String email;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String zip;
    private String category;
    private String imagename;
    private String productname;
   private String price;
  


}
