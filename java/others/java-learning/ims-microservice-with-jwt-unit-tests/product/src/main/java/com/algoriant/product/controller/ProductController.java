package com.algoriant.product.controller;


import com.algoriant.product.model.*;
import com.algoriant.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) throws RuntimeException {
            return new ResponseEntity<>(service.createProduct(productRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable("id") int id){
        service.removeProduct(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/modifyProduct/{id}")
    public ResponseEntity<Product> modifyProduct(@PathVariable("id") int id,@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>( service.modifyProduct(id, productRequest),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        List<ProductDTO> productDTOList = service.getAllProduct();
        return new ResponseEntity<>(productDTOList,HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") int id)  {
        return new ResponseEntity<>(service.getProduct(id),HttpStatus.OK);
    }

    @GetMapping("/sendProductById/{id}")
    public ResponseEntity<ProductDTO> sendProductById(@PathVariable("id") int id) throws ImsException{
         try {
             return new ResponseEntity<>(service.getProduct(id), HttpStatus.OK);
         } catch (Exception e) {
             throw new ImsException("There is some unexpected error occurring");
         }
    }

    @PutMapping("/changeQuantity/{id}/{quantity}")
    public ResponseEntity<Product> changeQuantity(@PathVariable("id") int id, @PathVariable("quantity") int quantity){
        return new ResponseEntity<>(service.changingQuantity(id,quantity),HttpStatus.OK);
    }

    @PutMapping("/updateQuantity/{id}/{quantity}")
    public ResponseEntity<Product> updateQuantity(@PathVariable("id") int id, @PathVariable("quantity") int quantity){
        return new ResponseEntity<>(service.updateQuantity(id,quantity),HttpStatus.OK);
    }
}
