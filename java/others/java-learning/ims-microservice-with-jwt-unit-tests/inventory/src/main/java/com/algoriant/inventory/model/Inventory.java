package com.algoriant.inventory.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static java.lang.String.valueOf;

@Entity
@Table(name = "inventory")
@SequenceGenerator(name="inventory",sequenceName = "inventory",allocationSize = 2)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;
    @Column(name = "item_id",unique = true)
    private String itemId;
    @Column(name = "p_id")
    private int productId;
    @Column(name = "location")
    private String location;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "i_status")
    @Enumerated(EnumType.STRING)
    private InventoryEnum status;
    @ManyToMany
    @JoinTable(name = "inventory_location",joinColumns = @JoinColumn(name = "p_id"),inverseJoinColumns = @JoinColumn(name = "location"))


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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



    public Inventory() {
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return valueOf(status);
    }

    public void setStatus(String status) {
        this.status = InventoryEnum.valueOf(status);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", itemId='" + itemId + '\'' +
                ", productId=" + productId +
                ", location='" + location + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                '}';
    }

    public static Inventory toEntity(InventoryRequest inventoryRequest){
        Inventory inventory = new Inventory();
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setStatus(inventoryRequest.getStatus());
        inventory.setLocation(inventoryRequest.getLocation());
        inventory.setProductId(inventoryRequest.getProductId());
        return  inventory;
    }
}
