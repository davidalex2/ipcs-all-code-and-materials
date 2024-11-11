package com.algoriant.inventory.service;

import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryDTO;
import com.algoriant.inventory.model.InventoryRequest;
import com.algoriant.inventory.model.Product;
import com.algoriant.inventory.repository.InventorytRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


@Service
public class InventoryService {

    @Autowired
    private InventorytRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    private final static String URL_PRODUCT_UPDATE_QUANTITY = "http://localhost:8765/product-service/product/updateQuantity/";


    public Inventory createInventory(InventoryRequest inventoryRequest){
        Inventory inventory = new Inventory();
        inventory.setProductId(inventoryRequest.getProductId());
        inventory.setLocation(inventoryRequest.getLocation());
        inventory.setStatus(inventoryRequest.getStatus());
        inventory.setQuantity(inventoryRequest.getQuantity());
        long serialNumber = System.currentTimeMillis();
        String plainText= inventory.getProductId() + "_" + serialNumber;
        inventory.setItemId(base64Encode(plainText));
        return repository.save(inventory);
    }
    public static String base64Encode(String plainText) {
        byte[] plainTextBytes = plainText.getBytes();
        return Base64.getEncoder().encodeToString(plainTextBytes);
    }
    public void removeInventory(int id ){
        repository.deleteById(id);
    }
    public Inventory modifyInventory(int id , InventoryRequest inventoryRequest){
        Optional<InventoryDTO> optionalInventoryDTO = Optional.of(InventoryDTO.toDTO(repository.findById(id).get()));
        if(optionalInventoryDTO.isPresent()){
            InventoryDTO inventoryDTO = optionalInventoryDTO.get();
            Inventory inventory1 = new Inventory();
            inventory1.setInventoryId(id);
            inventory1.setItemId(inventoryDTO.getItemId());
            inventory1.setProductId(inventoryRequest.getProductId());
            inventory1.setLocation(inventoryRequest.getLocation());
            inventory1.setQuantity(inventoryRequest.getQuantity());
            inventory1.setStatus(inventoryRequest.getStatus());
            repository.save(inventory1);
            RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(URL_PRODUCT_UPDATE_QUANTITY+inventoryRequest.getProductId()+"/"+(inventoryDTO.getQuantity()-inventoryRequest.getQuantity()), Product.class);
            return inventory1;
        }
        return null;
    }

    public InventoryDTO getInventory(int id ){
        Optional<InventoryDTO> optionalInventoryDTO = Optional.of(InventoryDTO.toDTO(repository.findById(id).get()));
        if(optionalInventoryDTO.isPresent()){
            return optionalInventoryDTO.get();
        }
        return   null;
    }

    public List<InventoryDTO> getAllInventory(){
        List<Inventory> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return InventoryDTO.toDTOList(list);
    }


}
