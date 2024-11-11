package com.algoriant.product.model;


public class ProductRequest {

    private String productName;
    private String category;
    private double price;
    private String status;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public static ProductRequest toDto(Product product){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductName(product.getProductName());
        productRequest.setCategory(product.getCategory());
        productRequest.setStatus(product.getStatus());
        productRequest.setPrice(product.getPrice());
        productRequest.setQuantity(product.getQuantity());
        return productRequest;
    }
}
