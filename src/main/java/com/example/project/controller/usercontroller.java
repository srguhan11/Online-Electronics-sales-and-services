package com.example.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project.entity.usersign;
import com.example.project.repo.userrepository;
import com.example.project.services.uservice;
@ComponentScan
@Controller
public class usercontroller {
    public static String temail;

    @Autowired
    private uservice service;

    @Autowired
    private userrepository repo;

    //getmapping

   
    @GetMapping("/products")
    public String products(Model model)
    {
      
        return "category";
    }
    @GetMapping("/services")
    public String services(Model model)
    {
      
        return "services";
    }
   
    @GetMapping("/")
    public String home(Model model)
    {
      
        return "home";
    }
   
@GetMapping("/home")
public String home2()
{
    return "home2";
}

    @GetMapping("/register")
    public String register(Model model)
    {
       usersign user=new usersign();
        model.addAttribute("user", user);
        return "usersign";
    }

     @GetMapping("/login")
     public String login(Model model)
    {
   usersign user=new usersign();
    model.addAttribute("user", user);
    return "userlogin";

     }


   //postmapping

@PostMapping("/reguser")
    public String reguser(@ModelAttribute("user")usersign user)
    {
        String result;
        System.out.println(user);
        if(user.getPassword().equals(user.getConfirmpassword()))
        {
        service.userregister(user);
        result ="success";
        }
        else{
       result="usererror";
        }
       return result;
    }


//////postmapping
    @PostMapping("/loguser")
    public String loginuser(@ModelAttribute("user")usersign user)
    {
        String result,email="admin@gmail.com",pass="ad123";
       
        temail=user.getEmail();
        System.out.println(temail);
        System.out.println(user.getPassword());
     
       Optional<usersign> uemail=repo.findById(user.getEmail());
      
         if(user.getEmail().equals(email)&&user.getPassword().equals(pass))
        {
          result="adminhome";
        }

     else if(user.getPassword().equals(uemail.get().getPassword()))
        {
                  
         result ="home2";
         }
      
        else{
       result ="usererror";
        }
       return result;

    }
}
