package com.algoriant.inventory.repository;

import com.algoriant.inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventorytRepository extends CrudRepository<Inventory,Integer> {
}
