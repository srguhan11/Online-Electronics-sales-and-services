package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.project.services.Catser;
import com.example.project.services.PorderService;
import com.example.project.services.ProductService;
import com.example.project.entity.*;

@Controller
public class ShopController {
  public static String Tprice;
  public static String pname;
  public static String timage;
  public static String tcategory;

  

    @Autowired
    private Catser categoryservices;
    @Autowired
    private ProductService productService;
   @Autowired
   private PorderService oservice;


    @GetMapping("/shop")
    public String shop(Model model)
    {
      
        model.addAttribute("categories", categoryservices.getAllCategory());
       model.addAttribute("products", productService.getAllProduct());
     return "shop";
    }
    

    @GetMapping("/shop/category/{id}")
    public String list(Model model,@PathVariable int id)
    {
     
       model.addAttribute("categories",categoryservices.getAllCategory());
    model.addAttribute("products", productService.getAllProductsByCategoryId(id));
    
       return "shop";
    }
 

    @GetMapping("/shop/viewshop/{id}")
    public String view(Model model,@PathVariable int id)
    {
      
      Tprice=String.valueOf(productService.getProductById(id).get().getPrice());
      pname=productService.getProductById(id).get().getName();
      tcategory=String.valueOf(productService.getProductById(id).get().getCategory().getName());
      timage=productService.getProductById(id).get().getImageName();
   
        model.addAttribute("products",productService.getProductById(id).get());
        return "viewshop";   
       }



        @GetMapping("/orderform")
        public String orderform(Model model)
        {
         
             ProductOrder productOrder=new ProductOrder();
             productOrder.setProductname(pname);
             productOrder.setPrice(Tprice); 
            model.addAttribute("orform", productOrder);
           
              return "orderform";
        }
        

        @PostMapping("/oform")
        public String form(@ModelAttribute("orform") ProductOrder productOrder)
        {
          String result=" ";
    productOrder.setImagename(timage);
          productOrder.setProductname(pname);
          productOrder.setPrice(Tprice);
          productOrder.setCategory(tcategory);
        
  
            oservice.details(productOrder);
            if(productOrder.equals(null))
            {
            
              result="error";
            }
            else{
                
                 result="shopsuccessfully";
               }
       
            return result;
        }

////////myorders
@GetMapping("/myorder")
public String myorder(Model model)
{
   
   model.addAttribute("orders", oservice.findbyemail(usercontroller.temail));
 
 
  
  return "myorder" ;
}
      
@GetMapping("/myorder/delete/{id}")
public String deleteorder(@PathVariable Integer id)
{
oservice.removeProductById(id);
return "redirect:/myorder";
}



}