package com.algoriant.product.service;

import com.algoriant.product.model.Product;
import com.algoriant.product.model.ProductDTO;
import com.algoriant.product.model.ProductRequest;
import com.algoriant.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    Product product = new Product();
    private final static String URL_SUPPLIER = "http://localhost:8765/supplier-service/supplier/sendSupplier/";

    public Product createProduct(ProductRequest productRequest){
        return repository.save(Product.toEntity(productRequest));
    }
    public void removeProduct(int id ){
        repository.deleteById(id);
    }
    public Product modifyProduct(int id , ProductRequest productRequest){
        Product product = new Product();
        Optional<ProductDTO> optionalProductDTO = Optional.of(ProductDTO.toDTO(repository.findById(id).get()));
        if(optionalProductDTO.isPresent()){
            product.setProductId(id);
            product.setProductName(productRequest.getProductName());
            product.setCategory(productRequest.getCategory());
            product.setPrice(productRequest.getPrice());
            product.setStatus(productRequest.getStatus());
            product.setQuantity(productRequest.getQuantity());
            repository.save(product);
        }
        return product;
    }

    public ProductDTO getProduct(int id ){
        Optional<ProductDTO> optionalProductDTO = Optional.of(ProductDTO.toDTO(repository.findById(id).get()));
        if(optionalProductDTO.isPresent()){
            return optionalProductDTO.get();
        }
        return null;
    }

    public List<ProductDTO> getAllProduct(){
        List<Product> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return ProductDTO.toDTOList(list);
    }

    public Product changingQuantity(int id,int quantity){
        Optional<ProductDTO> optionalProductDTO = Optional.of(ProductDTO.toDTO(repository.findById(id).get()));
        Product product = new Product();
        if (optionalProductDTO.isPresent()){
            ProductDTO productDTO = optionalProductDTO.get();
            product.setProductId(id);
            product.setProductName(productDTO.getProductName());
            product.setCategory(productDTO.getCategory());
            product.setPrice(productDTO.getPrice());
            product.setStatus(productDTO.getStatus());
            product.setQuantity(productDTO.getQuantity()-quantity);
            repository.save(product);
        }
       return product;
    }

    public Product updateQuantity(int id,int quantity){
        Optional<ProductDTO> optionalProductDTO = Optional.of(ProductDTO.toDTO(repository.findById(id).get()));
        Product product = new Product();
        if (optionalProductDTO.isPresent()){
            ProductDTO productDTO = optionalProductDTO.get();
            product.setProductId(id);
            product.setProductName(productDTO.getProductName());
            product.setCategory(productDTO.getCategory());
            product.setPrice(productDTO.getPrice());
            product.setStatus(productDTO.getStatus());
            product.setQuantity(productDTO.getQuantity()+quantity);
            repository.save(product);
        }
        return product;
    }
}
