package com.algoriant.inventory.controller;


import com.algoriant.inventory.model.ImsException;
import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryDTO;
import com.algoriant.inventory.model.InventoryRequest;
import com.algoriant.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/inventoryController")
public class InventoryController {

    @Autowired
    private InventoryService service;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/createInventory")
    public ResponseEntity<Inventory> createInventory(@RequestBody InventoryRequest inventoryRequest){
        return new ResponseEntity<>(service.createInventory(inventoryRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deleteInventory/{id}")
    public ResponseEntity<String> removeInventory(@PathVariable("id") int id){
        service.removeInventory(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/modifyInventory/{id}")
    public ResponseEntity<Inventory> modifyInventory(@PathVariable("id") int id,@RequestBody InventoryRequest inventoryRequest) throws ImsException {
    try {
        return new ResponseEntity<>( service.modifyInventory(id, inventoryRequest),HttpStatus.OK);

    }catch (Exception e){
        throw new ImsException("There is a problem please try again after sometime");
    }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllInventory")
    public ResponseEntity<List<InventoryDTO>> getAllInventory(){
        List<InventoryDTO> inventoryDTOList = service.getAllInventory();
        return new ResponseEntity<>(inventoryDTOList,HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/getInventoryById/{id}")
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getInventory(id),HttpStatus.OK);
    }

}
