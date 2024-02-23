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
@Table(name="serviceOrder")
public class ServiceOrder {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int ids;

private String sname;

@ManyToOne (fetch = FetchType.LAZY)
@JoinColumn (name = "service_category", referencedColumnName = "id")
private  Scategory scategory;
private String modelname;
private String email;
private String address;
private String Startdate;
private String Enddate;
private String city;
private String state;
private String phone;
private String zip;
private String iname;
private String description;

}
