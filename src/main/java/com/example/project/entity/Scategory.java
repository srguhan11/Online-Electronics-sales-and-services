package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="serviceCategory")
public class Scategory {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int id;
    public String name;
    
}
