package com.domain.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.domain.DTO.BaseResponse;
import com.domain.DTO.ProductDTO;
import com.domain.DTO.ResponseData;
import com.domain.models.entity.Product;
import com.domain.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@Service
@Transactional


public  class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ResponseEntity<BaseResponse<Product>> save(Product productRequest, Errors errors){
        Product newProduct = productRepo.save(productRequest);
        BaseResponse<Product> responseData = new BaseResponse<>();


        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.setMessage(error.getDefaultMessage());
            }
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage("FAILED");
            responseData.setResult(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(Boolean.TRUE);
        responseData.setMessage("SUCCESS");
        responseData.setResult(newProduct);
        return ResponseEntity.ok(responseData);
    }

    public ResponseEntity<BaseResponse> find(Long id){
        Optional<Product> productData = productRepo.findById(id);
        ProductDTO productDTO = ProductDTO.builder()
                .id(productData.get().getId())
                .name(productData.get().getName())
                .description(productData.get().getDescription())
                .build();
        BaseResponse response = BaseResponse.builder()
                .status(Boolean.TRUE)
                .message("SUCCESS")
                .result(productDTO)
                .build();
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<BaseResponse> findAll(){
        Iterable<Product> productlist = productRepo.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        productlist.forEach(product -> {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();
            productDTOList.add(productDTO);
        });
        BaseResponse responseData = BaseResponse.builder()
                .status(Boolean.TRUE)
                .message("SUCCESS")
                .result(productDTOList)
                .build();
        return ResponseEntity.ok(responseData);
    }

    public ResponseEntity<BaseResponse> removeOne(Long id){
        productRepo.deleteById(id);
        BaseResponse response = BaseResponse.builder()
                .status(Boolean.TRUE)
                .message("SUCCESS")
                .result("Product has been deleted")
                .build();
        return ResponseEntity.ok(response);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }

    public ResponseEntity<BaseResponse<Product>> update(Product productUpdate, Errors errors){
        Product updatedProduct = productRepo.save(productUpdate);
        BaseResponse<Product> responseData = new BaseResponse<>();


        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.setMessage(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setResult(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setResult(updatedProduct);
        return ResponseEntity.ok(responseData);
    }
}
