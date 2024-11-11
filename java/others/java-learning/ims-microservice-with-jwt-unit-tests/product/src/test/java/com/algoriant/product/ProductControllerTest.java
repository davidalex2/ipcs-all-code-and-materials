package com.algoriant.product;

import com.algoriant.product.controller.ProductController;
import com.algoriant.product.model.Product;
import com.algoriant.product.model.ProductDTO;
import com.algoriant.product.model.ProductRequest;
import com.algoriant.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ProductControllerTest {

    @Mock
    private ProductService productService;
    @InjectMocks
    ProductController productController;
    @Test
    public void saveProduct(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            when(productService.createProduct(ProductRequest.toDto(product))).thenReturn(product);
            ResponseEntity<Product> productResponseEntity = productController.createProduct(ProductRequest.toDto(product));
            assertEquals(HttpStatus.CREATED,productResponseEntity.getStatusCode());

        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing SaveSupplier method",th);
        }
    }
    @Test
    public void findProductById(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            when(productService.getProduct(product.getProductId())).thenReturn(ProductDTO.toDTO(product));
            ResponseEntity<ProductDTO> productDTOResponseEntity = productController.getProductById(product.getProductId());
            assertEquals(HttpStatus.OK,productDTOResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing findProductById method",th);
        }
    }
    @Test
    public void getAllProduct(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            productService.createProduct(ProductRequest.toDto(product));
            Product product1 = new Product();
            product1.setProductName("lux");
            product1.setCategory("shop");
            product1.setPrice(30);
            product1.setStatus("available");
            productService.createProduct(ProductRequest.toDto(product));
            List<Product> list = new ArrayList<>();
            list.add(product);
            list.add(product1);
            when(productService.getAllProduct()).thenReturn(ProductDTO.toDTOList(list));
            ResponseEntity<List<ProductDTO>> listResponseEntity = productController.getAllProduct();
            assertEquals(HttpStatus.OK,listResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getAllProduct method",th);
        }
    }
    @Test
    public void deleteProductTest(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            productService.createProduct(ProductRequest.toDto(product));
            productService.removeProduct(product.getProductId());
            ResponseEntity<String> stringResponseEntity = productController.removeProduct(product.getProductId());
            assertEquals(HttpStatus.OK,stringResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteProductTest method",th);
        }
    }
    @Test
    public void modifyProduct(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            ProductRequest productRequest = ProductRequest.toDto(product);
            when(productService.modifyProduct(product.getProductId(),productRequest)).thenReturn(product);
            ResponseEntity<Product> productResponseEntity = productController.modifyProduct(product.getProductId(),productRequest);
            assertEquals(HttpStatus.OK,productResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing modifyProduct method",th);
        }
    }
}
