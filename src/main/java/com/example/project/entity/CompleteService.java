package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="completeServiceorder")
public class CompleteService {
    @Id
    private int id;
    private String name;

private String modelname;
private String email;
private String address;
private String Startdate;
private String Enddate;
private String city;
private String state;
private String phone;
private String zip;

private String description;
}
