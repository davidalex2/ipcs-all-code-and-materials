package com.algoriant.product.model;

import org.springframework.security.core.parameters.P;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int productId;
    @Column(name = "p_name")
    private String productName;
    @Column(name = "p_category")
    private String category;
    @Column(name = "p_price")
    private double price;
    @Column(name = "p_status")
    @Enumerated(EnumType.STRING)
    private ProductEnum status;
    @Column(name = "p_q")
    private int quantity;


    public Product(int productId, String productName, String category, double price, ProductEnum status, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(String status) {
        this.status = ProductEnum.valueOf(status);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ",quantity=" + quantity +'\''+
                '}';
    }

    public static Product toEntity(ProductRequest productRequest) {

        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setStatus(productRequest.getStatus());
        product.setQuantity(productRequest.getQuantity());
        return product;
    }
}
