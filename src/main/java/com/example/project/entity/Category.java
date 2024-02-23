package com.example.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

import lombok.Data;



@Entity
@Data
@Table(name="productCategory")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="category_id")
    private int id;
    private String name;
}
