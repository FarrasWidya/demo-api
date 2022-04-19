package com.domain.services;


import java.util.List;

import javax.transaction.Transactional;

import com.domain.models.entity.Product;
import com.domain.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional


public  class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product find(Long id){
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void removeOne(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
