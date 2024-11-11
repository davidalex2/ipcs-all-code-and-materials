package com.algoriant.inventory.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class InventoryRequest {

    private int quantity;
    private String status;
    private String location;
    private int productId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public static InventoryRequest toDto(Inventory inventory){
        InventoryRequest inventoryRequest = new InventoryRequest();
        inventoryRequest.setLocation(inventory.getLocation());
        inventoryRequest.setStatus(inventory.getStatus());
        inventoryRequest.setQuantity(inventory.getQuantity());
        return inventoryRequest;
    }
}
