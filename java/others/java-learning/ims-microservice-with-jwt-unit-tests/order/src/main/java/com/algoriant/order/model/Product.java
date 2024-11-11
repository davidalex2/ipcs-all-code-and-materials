package com.algoriant.order.model;

public class Product {

    private int productId;
    private String productName;
    private String category;
    private double price;
    private String status;
    private int quantity;



    public Product(int productId, String productName, String category, double price, int quantity, String status) {
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                ", quantity='" +quantity+ '\'' +
                '}';
    }
}
