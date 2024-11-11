package com.algoriant.inventory.model;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class InventoryDTO {

    private String itemId;
    private int inventoryId;
    private int productId;
    private int quantity;
    private String status;
    private String location;
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public static InventoryDTO toDTO(Inventory inventory) {

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setItemId(inventory.getItemId());
        inventoryDTO.setInventoryId(inventory.getInventoryId());
        inventoryDTO.setLocation(inventory.getLocation());
        inventoryDTO.setStatus(inventory.getStatus());
        inventoryDTO.setProductId(inventoryDTO.getProductId());
        inventoryDTO.setQuantity(inventory.getQuantity());
        return inventoryDTO;
    }

    public static List<InventoryDTO> toDTOList(List<Inventory> inventories) {

        List<InventoryDTO> inventoryDTOS = new ArrayList<>();
        for (Inventory inventory : inventories) {
            InventoryDTO inventoryDTO = new InventoryDTO();
            inventoryDTO.setItemId(inventory.getItemId());
            inventoryDTO.setInventoryId(inventory.getInventoryId());
            inventoryDTO.setLocation(inventory.getLocation());
            inventoryDTO.setProductId(inventory.getProductId());
            inventoryDTO.setStatus(inventory.getStatus());
            inventoryDTO.setQuantity(inventory.getQuantity());
            inventoryDTOS.add(inventoryDTO);

        }
        return inventoryDTOS;
    }


    public static String base64Decode(String base64EncodedData){
        byte[] base64EncodedBytes = Base64.getDecoder().decode(base64EncodedData);
        return new String(base64EncodedBytes);
    }
}
