package com.algoriant.product;

import com.algoriant.product.model.Product;
import com.algoriant.product.model.ProductDTO;
import com.algoriant.product.model.ProductRequest;
import com.algoriant.product.repository.ProductRepository;
import com.algoriant.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    ProductService productService;
    @Test
    public void saveProduct(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            Product saveProduct = productRepository.save(product);
            when(productRepository.save(product)).thenReturn(product);
            assertEquals(saveProduct,productService.createProduct(ProductRequest.toDto(product)));
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing saveProduct method",th);
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
            productRepository.save(product);
            when(productRepository.findById(product.getProductId())).thenReturn(Optional.of(product));
            ProductDTO productDTO =  productService.getProduct(product.getProductId());
            assertEquals(product.getProductId(),productDTO.getProductId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing findProductById method",th);
        }
    }
    @Test
    public void findAllProduct(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            productRepository.save(product);
            Product product1 = new Product();
            product1.setProductName("lux");
            product1.setCategory("shop");
            product1.setPrice(30);
            product1.setStatus("available");
            productRepository.save(product1);
            List<Product> list = new ArrayList<>();
            list.add(product);
            list.add(product1);
            when(productRepository.findAll()).thenReturn(list);
            assertEquals(list,productRepository.findAll());

        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing findAllProduct method",th);
        }
    }
    @Test
    public void deleteProductById(){
        try{
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            productRepository.save(product);
            productService.removeProduct(product.getProductId());
            verify(productRepository,times(1)).deleteById(product.getProductId());

        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteProductById method",th);
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
            when(productRepository.findById(product.getProductId())).thenReturn(Optional.of(product));
            when(productRepository.save(any())).thenReturn(product);
            Product product1 = productService.modifyProduct(product.getProductId(),ProductRequest.toDto(product));
            assertEquals(product.getProductId(),product1.getProductId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing modifyProduct method",th);
        }
    }
}
