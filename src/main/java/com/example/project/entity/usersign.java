package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="userDetails")
public class usersign {
    @Id
    private String email;
    private String username;
    private String phonenumber;
    private String password;
    private String confirmpassword;
  
   
  

}
