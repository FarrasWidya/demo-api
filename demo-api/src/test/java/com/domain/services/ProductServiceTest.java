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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

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
}
