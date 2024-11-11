package com.algoriant.product;

import com.algoriant.product.model.Product;
import com.algoriant.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestProductRepository {
    @Autowired
    private ProductRepository repository;

    @Test
    @DisplayName("Create method in repository")
    void createProductRepo(){
        try {
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");

            Product saveProduct = repository.save(product);
            assertThat(saveProduct.getProductName()).isEqualTo("lux");
            assertThat(saveProduct).isNotNull();
            assertThat(saveProduct.getProductId()).isNotNull();
        } catch (Throwable throwable) {
            throw new RuntimeException("Error occurring while Running Create Product",throwable);
        }
    }

    @Test
    @DisplayName("Update method in repository")
    void updateProductRepo(){
        try {
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            repository.save(product);
            Product saveProduct = repository.findById(product.getProductId()).get();
            saveProduct.setProductName("detoil");
            saveProduct.setPrice(100);
            Product updateProduct = repository.save(saveProduct);
            assertThat(updateProduct.getProductName()).isEqualTo("detoil");
            assertThat(updateProduct.getPrice()).isEqualTo(100);

        } catch (Throwable th){
            throw new RuntimeException("Error occurring while Running Update product Repository",th);
        }

    }

    @Test
    @DisplayName("Delete method in repository")
    void deleteProductRepoo(){
        try {
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            repository.save(product);
            repository.deleteById(product.getProductId());
            Optional<Product> deleteProduct = repository.findById(product.getProductId());
            assertThat(deleteProduct).isEmpty();
        } catch (Throwable th){
            throw new RuntimeException("Error occurring while Running Delete product Repository",th);
        }
    }

    @Test
    @DisplayName("findById method in repository")
    void findByIdProductRepoo(){
        try {
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");
            repository.save(product);
            Optional<Product> findById = repository.findById(product.getProductId());
            assertThat(findById).isNotNull();
        } catch (Throwable th){
            throw new RuntimeException("Error occurring while Running findById product Repository",th);
        }
    }

    @Test
    @DisplayName("findAll method in repository")
    void findAllProductRepoo(){
        try {
            Product product = new Product();
            product.setProductName("lux");
            product.setCategory("shop");
            product.setPrice(30);
            product.setStatus("available");

            Product product1 = new Product();
            product1.setProductName("lux");
            product1.setCategory("shop");
            product1.setPrice(30);
            product1.setStatus("available");
            repository.save(product1);

            List<Product> listProduct = (List<Product>) repository.findAll();
            assertThat(listProduct).isNotNull();
            assertThat(listProduct.size()).isGreaterThan(1);

        } catch (Throwable th){
            throw new RuntimeException("Error occurring while Running findAll product Repository",th);
        }
    }
}
