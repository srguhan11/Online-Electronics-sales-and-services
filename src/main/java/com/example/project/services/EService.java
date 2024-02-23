package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.ServiceEntity;
import com.example.project.repo.Servicerepo;
import java.util.List;
import java.util.Optional;
@Service
public class EService {
    @Autowired
    public Servicerepo servicerepo;

    public void servicesave(ServiceEntity serviceEntity)
    {
        servicerepo.save(serviceEntity);
    }

    public List<ServiceEntity> getallservice()
    {
     return servicerepo.findAll();
    }

  public void removeservice(int id)
  {
    servicerepo.deleteById(id);
  }

public Optional<ServiceEntity> upservice(int id)
{
    return servicerepo.findById(id);
}
   
}
