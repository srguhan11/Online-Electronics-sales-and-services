package com.example.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.entity.ServiceOrder;
import com.example.project.entity.SorderDTO;
import com.example.project.services.EService;
import com.example.project.services.SOrderService;
import com.example.project.services.Scat;
import com.example.project.services.uservice;
@Controller
public class ServiceController {

 



  @Autowired
  public uservice uservice;
@Autowired
public Scat scat;
@Autowired
private SOrderService sOrderService;
@Autowired
public EService eService;
  @GetMapping("/servicepage")
  public String spage(Model model)
  {
    model.addAttribute("displayservice",eService.getallservice());
    return "servicepage";
  }

  @GetMapping("/serviceorder")
public String serviceorder(Model model)
{
  
  model.addAttribute("sorder",new SorderDTO());
  model.addAttribute("scategories", scat.getAllSCategory());
 
  return "serviceorder";
  
}



////postmapping
@PostMapping("/servicesorder")
public String orderservice(@ModelAttribute("sorder") SorderDTO sorderDTO, 
                           @RequestParam("ServiceImage")MultipartFile file,
                           @RequestParam("imgname")String imgname) throws IOException
{
  String result;
 ServiceOrder serviceOrder=new ServiceOrder();
 serviceOrder.setIds(sorderDTO.getIds());
 serviceOrder.setSname(sorderDTO.getSname());
 serviceOrder.setScategory(scat.findbyid(sorderDTO.getServiceid()).get());
 serviceOrder.setEmail(sorderDTO.getEmail());
 serviceOrder.setModelname(sorderDTO.getModelname());
 serviceOrder.setStartdate(sorderDTO.getStartdate());
 serviceOrder.setEnddate(sorderDTO.getEnddate());
 serviceOrder.setAddress(sorderDTO.getAddress());
 serviceOrder.setPhone(sorderDTO.getPhone());
 serviceOrder.setCity(sorderDTO.getCity());
 serviceOrder.setState(sorderDTO.getState());
 serviceOrder.setZip(sorderDTO.getZip());
 serviceOrder.setDescription(sorderDTO.getDescription());

 String imageUUID;
 if(!file.isEmpty()) 
 {
 imageUUID = file.getOriginalFilename();
 System.out.println(imageUUID);
 Path fileNameAndPath=Paths.get(AdminController.uploadDir,imageUUID);
 System.out.println(fileNameAndPath);
 Files.write(fileNameAndPath, file.getBytes());
 }
 else
 {
 imageUUID = imgname;
 }
 serviceOrder.setIname(imageUUID);
 System.out.println(serviceOrder);
  sOrderService.sorder(serviceOrder);
  
  if(serviceOrder.equals(null))
  {
  
    result="error";
  }
  else{
      
       result="servicesuccessfully";
     }

  return result;
}

@GetMapping("/myorders")
public String order(Model model)
{

  model.addAttribute("orders",sOrderService.Findbyemailid(usercontroller.temail));
return "myorder2";
}

@GetMapping("/myorders/delete/{id}")
public String deleteorder(@PathVariable Integer id)
{
sOrderService.deletebyid(id);
return "redirect:/myorders";
}
}
