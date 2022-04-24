package com.domain.services;

import com.domain.DTO.BaseResponse;
import com.domain.DTO.ProductDTO;
import com.domain.models.entity.Product;
import com.domain.models.repos.ProductRepo;
import com.domain.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class ProductServiceTest {
    @Mock
    ProductRepo productRepo;
    ProductService productService;

    @Test
    void testFind_then_returnOK() {
        productService = new ProductService(productRepo);
        Long id = 777L;
        Product productData = new Product();
        productData.setId(id);
        productData.setName("Cupcake");
        productData.setDescription("Strawberry cupcake");
        productData.setPrice(Double.valueOf(200000));

        ProductDTO dtoResult = ProductDTO.builder()
                .id(productData.getId())
                .name(productData.getName())
                .description(productData.getDescription())
                .build();

        when(productRepo.findById(id)).thenReturn(Optional.of(productData));
        ResponseEntity<BaseResponse> result = productService.find(id);
        assertThat(result.getStatusCode().value()).isEqualTo(200);
        assertThat(result.getBody().getMessage()).isEqualTo("SUCCESS");
    }

    @Test
    void testDelete_then_returnOK(){
        productService = new ProductService(productRepo);
        Long id = 13l;
        doNothing().when(productRepo).deleteById(id);
        ResponseEntity<BaseResponse> result = productService.removeOne(id);
        assertThat(result.getStatusCode().value()).isEqualTo(200);
        assertThat(result.getBody().getMessage()).isEqualTo("SUCCESS");
    }

    @Test
    void testUpdate_then_returnOK(){
        productService = new ProductService(productRepo);
        Product productData = new Product();
        productData.setId(1L);
        productData.setName("Mouse Gaming");
        productData.setDescription("Mouse Gaming merah");
        productData.setPrice(Double.valueOf(50000));
        Errors errors= new Errors() {
            @Override
            public String getObjectName() {
                return null;
            }

            @Override
            public void setNestedPath(String nestedPath) {

            }

            @Override
            public String getNestedPath() {
                return null;
            }

            @Override
            public void pushNestedPath(String subPath) {

            }

            @Override
            public void popNestedPath() throws IllegalStateException {

            }

            @Override
            public void reject(String errorCode) {

            }

            @Override
            public void reject(String errorCode, String defaultMessage) {

            }

            @Override
            public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode) {

            }

            @Override
            public void rejectValue(String field, String errorCode, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void addAllErrors(Errors errors) {

            }

            @Override
            public boolean hasErrors() {
                return false;
            }

            @Override
            public int getErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getAllErrors() {
                return null;
            }

            @Override
            public boolean hasGlobalErrors() {
                return false;
            }

            @Override
            public int getGlobalErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getGlobalErrors() {
                return null;
            }

            @Override
            public ObjectError getGlobalError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors() {
                return false;
            }

            @Override
            public int getFieldErrorCount() {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors() {
                return null;
            }

            @Override
            public FieldError getFieldError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors(String field) {
                return false;
            }

            @Override
            public int getFieldErrorCount(String field) {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors(String field) {
                return null;
            }

            @Override
            public FieldError getFieldError(String field) {
                return null;
            }

            @Override
            public Object getFieldValue(String field) {
                return null;
            }

            @Override
            public Class<?> getFieldType(String field) {
                return null;
            }
        };

        when(productRepo.save(productData)).thenReturn(productData);
        ResponseEntity<BaseResponse<Product>> result = productService.update(productData,errors);
        assertThat(result.getStatusCode().value()).isEqualTo(200);
        assertThat(result.getBody().getMessage()).isEqualTo("SUCCESS");


    }

    @Test
    void testFindAll_then_returnOK(){
        productService = new ProductService((productRepo));
        List<Product> productDatas = new ArrayList<>();
        Product productData = new Product();
        productData.setId(1L);
        productData.setName("Mouse Gaming");
        productData.setDescription("Mouse Gaming merah");
        productData.setPrice(Double.valueOf(50000));
        productDatas.add(productData);

        when(productRepo.findAll()).thenReturn(productDatas);
        ResponseEntity<BaseResponse> result = productService.findAll();
        assertThat(result.getStatusCode().value()).isEqualTo(200);
        assertThat(result.getBody().getMessage()).isEqualTo("SUCCESS");
    }

    @Test
    void testCreate_then_returnCREATE(){
        productService = new ProductService(productRepo);
        Product productData = new Product();
        productData.setId(1L);
        productData.setName("Mouse Gaming");
        productData.setDescription("Mouse Gaming merah");
        productData.setPrice(Double.valueOf(50000));
        Errors errors= new Errors() {
            @Override
            public String getObjectName() {
                return null;
            }

            @Override
            public void setNestedPath(String nestedPath) {

            }

            @Override
            public String getNestedPath() {
                return null;
            }

            @Override
            public void pushNestedPath(String subPath) {

            }

            @Override
            public void popNestedPath() throws IllegalStateException {

            }

            @Override
            public void reject(String errorCode) {

            }

            @Override
            public void reject(String errorCode, String defaultMessage) {

            }

            @Override
            public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode) {

            }

            @Override
            public void rejectValue(String field, String errorCode, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void addAllErrors(Errors errors) {

            }

            @Override
            public boolean hasErrors() {
                return false;
            }

            @Override
            public int getErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getAllErrors() {
                return null;
            }

            @Override
            public boolean hasGlobalErrors() {
                return false;
            }

            @Override
            public int getGlobalErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getGlobalErrors() {
                return null;
            }

            @Override
            public ObjectError getGlobalError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors() {
                return false;
            }

            @Override
            public int getFieldErrorCount() {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors() {
                return null;
            }

            @Override
            public FieldError getFieldError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors(String field) {
                return false;
            }

            @Override
            public int getFieldErrorCount(String field) {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors(String field) {
                return null;
            }

            @Override
            public FieldError getFieldError(String field) {
                return null;
            }

            @Override
            public Object getFieldValue(String field) {
                return null;
            }

            @Override
            public Class<?> getFieldType(String field) {
                return null;
            }
        };

        when(productRepo.save(productData)).thenReturn(productData);
        ResponseEntity<BaseResponse<Product>> result = productService.save(productData,errors);
        assertThat(result.getStatusCode().value()).isEqualTo(201);
        assertThat(result.getBody().getMessage()).isEqualTo("SUCCESS");

    }

    @Test
    void testCreate_then_returnERROR(){
        productService = new ProductService(productRepo);
        Product productData = new Product();
        productData.setId(1L);
        productData.setName("Mouse Gaming");
        productData.setDescription("Mouse Gaming merah");
        productData.setPrice(Double.valueOf(50000));
        Errors errors= new Errors() {
            @Override
            public String getObjectName() {
                return null;
            }

            @Override
            public void setNestedPath(String nestedPath) {

            }

            @Override
            public String getNestedPath() {
                return null;
            }

            @Override
            public void pushNestedPath(String subPath) {

            }

            @Override
            public void popNestedPath() throws IllegalStateException {

            }

            @Override
            public void reject(String errorCode) {

            }

            @Override
            public void reject(String errorCode, String defaultMessage) {

            }

            @Override
            public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode) {

            }

            @Override
            public void rejectValue(String field, String errorCode, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void addAllErrors(Errors errors) {

            }

            @Override
            public boolean hasErrors() {
                return true;
            }

            @Override
            public int getErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getAllErrors() {
                ObjectError error1 = new ObjectError("ERROR VALIDATION", "ERROR MESSAGE");
                List<ObjectError> errors = new ArrayList<>();
                errors.add(error1);
                return errors;
            }

            @Override
            public boolean hasGlobalErrors() {
                return false;
            }

            @Override
            public int getGlobalErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getGlobalErrors() {
                return null;
            }

            @Override
            public ObjectError getGlobalError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors() {
                return false;
            }

            @Override
            public int getFieldErrorCount() {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors() {
                return null;
            }

            @Override
            public FieldError getFieldError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors(String field) {
                return false;
            }

            @Override
            public int getFieldErrorCount(String field) {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors(String field) {
                return null;
            }

            @Override
            public FieldError getFieldError(String field) {
                return null;
            }

            @Override
            public Object getFieldValue(String field) {
                return null;
            }

            @Override
            public Class<?> getFieldType(String field) {
                return null;
            }
        };

        when(productRepo.save(productData)).thenReturn(productData);
        ResponseEntity<BaseResponse<Product>> result = productService.save(productData,errors);
        assertThat(result.getStatusCode().value()).isEqualTo(400);
        assertThat(result.getBody().getMessage()).isEqualTo("FAILED");

    }

    @Test
    void testUpdate_then_returnERROR(){
        productService = new ProductService(productRepo);
        Product productData = new Product();
        productData.setId(1L);
        productData.setName("Mouse Gaming");
        productData.setDescription("Mouse Gaming merah");
        productData.setPrice(Double.valueOf(50000));
        Errors errors= new Errors() {
            @Override
            public String getObjectName() {
                return null;
            }

            @Override
            public void setNestedPath(String nestedPath) {

            }

            @Override
            public String getNestedPath() {
                return null;
            }

            @Override
            public void pushNestedPath(String subPath) {

            }

            @Override
            public void popNestedPath() throws IllegalStateException {

            }

            @Override
            public void reject(String errorCode) {

            }

            @Override
            public void reject(String errorCode, String defaultMessage) {

            }

            @Override
            public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode) {

            }

            @Override
            public void rejectValue(String field, String errorCode, String defaultMessage) {

            }

            @Override
            public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {

            }

            @Override
            public void addAllErrors(Errors errors) {

            }

            @Override
            public boolean hasErrors() {
                return true;
            }

            @Override
            public int getErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getAllErrors() {
                ObjectError error1 = new ObjectError("ERROR VALIDATION", "ERROR MESSAGE");
                List<ObjectError> errors = new ArrayList<>();
                errors.add(error1);
                return errors;
            }

            @Override
            public boolean hasGlobalErrors() {
                return false;
            }

            @Override
            public int getGlobalErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getGlobalErrors() {
                return null;
            }

            @Override
            public ObjectError getGlobalError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors() {
                return false;
            }

            @Override
            public int getFieldErrorCount() {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors() {
                return null;
            }

            @Override
            public FieldError getFieldError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors(String field) {
                return false;
            }

            @Override
            public int getFieldErrorCount(String field) {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors(String field) {
                return null;
            }

            @Override
            public FieldError getFieldError(String field) {
                return null;
            }

            @Override
            public Object getFieldValue(String field) {
                return null;
            }

            @Override
            public Class<?> getFieldType(String field) {
                return null;
            }
        };

        when(productRepo.save(productData)).thenReturn(productData);
        ResponseEntity<BaseResponse<Product>> result = productService.update(productData,errors);
        assertThat(result.getStatusCode().value()).isEqualTo(400);
        assertThat(result.getBody().getMessage()).isEqualTo("FAILED");

    }

}
