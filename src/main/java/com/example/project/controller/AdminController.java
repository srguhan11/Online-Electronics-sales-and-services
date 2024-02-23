package com.example.project.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.entity.Category;
import com.example.project.entity.CompleteProduct;
import com.example.project.entity.CompleteService;
import com.example.project.entity.ProductOrder;
import com.example.project.entity.Products;
import com.example.project.entity.Scategory;
import com.example.project.entity.ServiceEntity;
import com.example.project.entity.ServiceOrder;
import com.example.project.entity.productDTO;
import com.example.project.repo.Scategoryrepo;
import com.example.project.services.Catser;
import com.example.project.services.Cproductorder;
import com.example.project.services.Cserviceorder;
import com.example.project.services.EService;
import com.example.project.services.PorderService;
import com.example.project.services.ProductService;
import com.example.project.services.SOrderService;
import com.example.project.services.Scat;
@Controller
public class AdminController {
  
    public static String uploadDir =System.getProperty("user.dir") + "/src/main/resources/static/productImages";


  @Autowired
  private Catser catservice;
  @Autowired
  ProductService productService;

  
  
 @GetMapping("/admin")
public String adminhome(Model model)
 {
      
    return "adminhome";
}


///////shop 
///category

 @GetMapping("/admin/category")
public String category(Model model)
{
model.addAttribute("categories",catservice.getAllCategory());
 return "category";

}

@GetMapping("/category/add")
public String categoryadd(Model model)
{
    model.addAttribute("categories",new Category());
    return "categoryadd";
    
}  
@GetMapping("/admin/category/delete/{id}")
public String  removecat(@PathVariable int id)
{
    catservice.removecat(id);
    return "redirect:/admin/category";
    
}

@GetMapping("/admin/category/update/{id}")
public String  updatecat(Model model,@PathVariable int id)
{
    String result="";
   Optional<Category> dl= catservice.findbyid(id);
   if(dl.isPresent())
   {
   model.addAttribute("categories", dl.get());

    result="categoryadd";
   }
   else
   {
    result="404";
   }
    return result;
    
}




//postmapping
@PostMapping("/admin/category/add")

    public String cat(@ModelAttribute("categories") Category category)
    {
        catservice.addcat(category);
        return "redirect:/admin/category";

    }



 ////Product Section
@GetMapping("/admin/product")
public String products (Model model) {
   model.addAttribute( "products", productService.getAllProduct());
    return "product";
}

@GetMapping("/admin/products/add")
public String productAddGet(Model model)
{
    model. addAttribute( "productDTO", new productDTO());
    model.addAttribute("categories",catservice.getAllCategory());
    
    return "productadd";
}

@GetMapping("/admin/product/delete/{id}")
public String  removeproduct(@PathVariable int id)
{
    productService.removeProductById(id);
    return "redirect:/admin/product";
    
}

@GetMapping("/admin/product/update/{id}")
public String  updateproduct(Model model,@PathVariable int id)
{
   Products pro=productService.getProductById(id).get();
   productDTO productDTO=new productDTO();
   
   productDTO.setId(pro.getId());
   productDTO.setName(pro.getName());
   productDTO.setCategoryId(pro.getCategory().getId());
   productDTO.setPrice(pro.getPrice());
   productDTO.setDescription(pro.getDescription());
   productDTO.setBrand(pro.getBrand() );
   productDTO.setImageName(pro.getImageName());

   model. addAttribute( "productDTO", productDTO);
   model.addAttribute("categories",catservice.getAllCategory());
    return "productadd";
    
}



//////postmapping
@PostMapping("/admin/products/add")
public String productAddPost(@ModelAttribute("productDTO")productDTO productDTO,
                             @RequestParam("productImage")MultipartFile file,
                             @RequestParam("imgName")String imgName) throws IOException {
Products product = new Products();
product.setId(productDTO.getId());
product.setName (productDTO.getName());
product.setCategory(catservice.findbyid(productDTO.getCategoryId()).get());
product.setPrice(productDTO.getPrice());
product.setBrand(productDTO.getBrand());
product.setDescription(productDTO.getDescription());
//System.out.println("point1");
String imageUUID;
if(!file.isEmpty()) 
{
imageUUID = file.getOriginalFilename();
//System.out.println(imageUUID);
Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
//System.out.println(fileNameAndPath);
Files.write(fileNameAndPath, file.getBytes());
}
else
{
imageUUID = imgName;
}
product.setImageName (imageUUID);
productService.addProduct(product);
return "redirect:/admin/product";
}
                              



///////////////////////////////////////////////////////////////////////services/////////////////////////////////////////////////////////////////////////////////////////////////////////////
@Autowired
public Scategoryrepo scategoryrepo;
@Autowired
public Scat scat;
@Autowired
public EService eService;

@GetMapping("/admin/service")
public String services()
{
    return "service";
}


@GetMapping("/admin/service/scategory")
public String dservice(Model model)
{
    model.addAttribute("scategories",scat.getAllSCategory());
    return "scategory";
}

@GetMapping("/admin/service/scategory/scategoryadd")
public String scategoryadd(Model model)
{
    model.addAttribute("scategories", new Scategory());
    return "scategoryadd";
}

@GetMapping("/admin/service/scategory/delete/{id}")
public String delete(@PathVariable int id)
{
    scat.removecat(id);
    return "redirect:/admin/service/scategory";
}


@GetMapping("/admin/service/scategory/update/{id}")
public String  updatescat(Model model,@PathVariable int id)
{
    String result="";
   Optional<Scategory> up= scat.findbyid(id);
   if(up.isPresent())
   {
   model.addAttribute("scategories", up.get());

    result="scategoryadd";
   }
   else
   {
    result=" ";
   }
    return result;
    
}

@GetMapping("/admin/service/displayservice")
public String displayservice(Model model)
{
    model.addAttribute("serviceadd",eService.getallservice());
    return "displayservice";
}

@GetMapping("/admin/service/displayservice/serviceadd")
public String serviceadd(Model model)
{
    model.addAttribute("serviceadd", new ServiceEntity()); 

 return "serviceadd";
}

@GetMapping("/admin/service/displayservice/delete/{id}")
public String servicedelete(@PathVariable int id)
{
    eService.removeservice(id);
    
     return "redirect:/admin/service/displayservice";
}

@GetMapping("/admin/service/displayservice/update/{id}")
public String serviceupdate(Model model,@PathVariable int id)
{
    String result="";
    Optional<ServiceEntity> up= eService.upservice(id);
   if(up.isPresent())
   {
   model.addAttribute("serviceadd", up.get());

    result="serviceadd";
   }
   else
   {
    result=" ";
   }
    return result;
    
}




///postMapping
@PostMapping("/admin/service/scategory/scategoryadd")
public String sercat(@ModelAttribute("scategories") Scategory scategory)
{
   scat.scategory(scategory);
    return "redirect:/admin/service/scategory";

}

@PostMapping("/admin/service/displayservice/serviceadd")
public String dservice(@ModelAttribute("serviceadd") ServiceEntity serviceEntity,  @RequestParam("productImage")MultipartFile file,
@RequestParam("imgname")String imgname) throws IOException
{

  String imageUUID;
    if(!file.isEmpty()) 
    {
    imageUUID = file.getOriginalFilename();
    System.out.println(imageUUID);
    Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
    System.out.println(fileNameAndPath); 
    Files.write(fileNameAndPath, file.getBytes());
    }
    else
    {
    imageUUID = imgname;
    }
    serviceEntity.setImagename(imageUUID);

    eService.servicesave(serviceEntity);
return "redirect:/admin/service/displayservice";
}


/////////////////////////////////////////////////////////////receive order////////////////////////////////////////////////////////////////////////////////////////
@Autowired
private PorderService porder;
@Autowired
private SOrderService sorder;
@Autowired
public Cproductorder cproductorder;
@Autowired
public Cserviceorder cserviceorder;

@GetMapping("/receiveorder")
public String order()
{
    
    return "ReceiveOrder";
}


@GetMapping("/ProductReceiveOrder")
public String productOrder(Model model)
{

    
    model.addAttribute("orders",porder.Findall());
    return "ProductReceiveOrder";
}

@GetMapping("/ServiceReceiveOrder")
public String service(Model model)
{
    model.addAttribute("sorders",sorder.Findall());
    return "ServiceReceiveOrder"; 
}
 
@GetMapping("/ProductReceiveOrder/delete/{id}")
public String delivered(@PathVariable Integer id )
{
    ProductOrder productOrder=porder.getProductById(id).get();
    CompleteProduct completeOrder=new CompleteProduct();
    completeOrder.setId(productOrder.getId()); 
    completeOrder.setName(productOrder.getName());
   // System.out.println(productOrder.getName());
    completeOrder.setEmail(productOrder.getEmail());
    completeOrder.setAddress(productOrder.getAddress());
    completeOrder.setPhone(productOrder.getPhone());
    completeOrder.setCity(productOrder.getCity());
    completeOrder.setState(productOrder.getState());
    completeOrder.setZip(productOrder.getZip());
    completeOrder.setCategory(productOrder.getCategory());
    completeOrder.setProductname(productOrder.getProductname());
    completeOrder.setPrice(productOrder.getPrice());
    System.out.println(completeOrder);
    cproductorder.completeOrder(completeOrder);
  
    porder.removeProductById(id);
    return "shopsuccess";
}


@GetMapping("/ServiceReceiveOrder/delete/{id}")
public String complete(@PathVariable Integer id)
{

    ServiceOrder serviceOrder=sorder.getProductById(id).get();
    CompleteService completeService=new CompleteService();
    completeService.setId(serviceOrder.getIds());
    completeService.setName(serviceOrder.getSname());
    completeService.setEmail(serviceOrder.getEmail());
    completeService.setStartdate(serviceOrder.getStartdate());
    completeService.setEnddate(serviceOrder.getEnddate());
    completeService.setAddress(serviceOrder.getAddress());
    completeService.setPhone(serviceOrder.getPhone());
    completeService.setCity(serviceOrder.getCity());
    completeService.setState(serviceOrder.getState());
    completeService.setZip(serviceOrder.getZip());
   // completeService.setScategory(serviceOrder.setScategory(sorderDTO.getServiceid()));
    completeService.setModelname(serviceOrder.getModelname());
    completeService.setDescription(serviceOrder.getDescription());
    cserviceorder.completeserviceOrder(completeService);
    sorder.deletebyid(id);
    return "servicesuccess";
}

@GetMapping("/CompleteOrder")
public String complete(Model model)
{
   
    return "completeorder";
}

@GetMapping("/CompleteProductOrder")
public String completed(Model model)
{
    model.addAttribute("cproductorder", cproductorder.Findall());
    return "cproductorder";
}



@GetMapping("/CompleteServiceOrder")
public String completeservice(Model model)
{
    model.addAttribute("cserviceorder", cserviceorder.Findall());
 
    return "cserviceorder";
}
}
