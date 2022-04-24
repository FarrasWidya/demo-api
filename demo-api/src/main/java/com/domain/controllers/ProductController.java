package com.domain.controllers;

import javax.validation.Valid;

import com.domain.DTO.BaseResponse;
import com.domain.DTO.ProductDTO;
import com.domain.DTO.ResponseData;
import com.domain.models.entity.Product;
import com.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<BaseResponse<Product>> create(@Valid @RequestBody Product product, Errors errors){
        return productService.save(product, errors);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> findAll(){
       return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> findOne(@PathVariable("id") Long id){
        return productService.find(id);
    }
    
    @PutMapping
    public ResponseEntity<BaseResponse<Product>> update(@Valid @RequestBody Product product, Errors errors){
       return productService.update(product, errors);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        return productService.removeOne(id);
    }
    
}
