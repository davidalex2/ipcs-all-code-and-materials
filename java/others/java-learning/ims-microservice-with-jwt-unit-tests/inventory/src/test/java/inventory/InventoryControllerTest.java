package inventory;

import com.algoriant.inventory.controller.InventoryController;
import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryDTO;
import com.algoriant.inventory.model.InventoryRequest;
import com.algoriant.inventory.service.InventoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = com.algoriant.inventory.InventoryApplication.class)
public class InventoryControllerTest {
        @Mock
        private InventoryService inventoryService;
        @InjectMocks
        InventoryController inventoryController;

        @Test
        @DisplayName("Creating a inventory")
        public void createInventoryTest() {
            try {
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                when(inventoryService.createInventory(InventoryRequest.toDto(inventory))).thenReturn(inventory);
                ResponseEntity<Inventory> responseEntity = inventoryController.createInventory(InventoryRequest.toDto(inventory));
                assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
            } catch (Throwable th){
                throw new RuntimeException("Error occurring while testing createInventoryTest method",th);
            }
        }
        @Test
        public void modifyInventory() {
            try {
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                InventoryRequest inventoryRequest = InventoryRequest.toDto(inventory);
                when(inventoryService.modifyInventory(inventory.getInventoryId(), inventoryRequest)).thenReturn(inventory);
                ResponseEntity<Inventory> responseEntity = inventoryController.modifyInventory(inventory.getInventoryId(), inventoryRequest);
                assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            } catch (Throwable th){
                throw new RuntimeException("Error occurring while testing modifyInventory method",th);
            }
        }
        @Test
        public void removeInventory() {
            try {
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                inventoryService.createInventory(InventoryRequest.toDto(inventory));
                inventoryService.removeInventory(inventory.getInventoryId());
                ResponseEntity<String> responseEntity = inventoryController.removeInventory(inventory.getInventoryId());
                assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            } catch (Throwable th){
                throw new RuntimeException("Error occurring while testing removeInventory method",th);
            }
        }
        @Test
        public void getInventoryById() {
            try {
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                when(inventoryService.getInventory(inventory.getInventoryId())).thenReturn(InventoryDTO.toDTO(inventory));
                ResponseEntity<InventoryDTO> responseEntity=inventoryController.getInventoryById(inventory.getInventoryId());
                assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            } catch (Throwable th){
                throw new RuntimeException("Error occurring while testing getInventoryById method",th);
            }
        }
        @Test
        public void getAllInventory() {
            try {
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                Inventory inventory2 = new Inventory();
                inventory.setInventoryId(3);
                inventory.setItemId("Ma");
                inventory.setProductId(2);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                List<Inventory> list = new ArrayList<>();
                list.add(inventory);
                list.add(inventory2);
                when(inventoryService.getAllInventory()).thenReturn(InventoryDTO.toDTOList(list));
                ResponseEntity<List<InventoryDTO>> responseEntity = inventoryController.getAllInventory();
                assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            }catch (Throwable th){
                throw new RuntimeException("Error occurring while testing getAllInventory method",th);
            }
        }


}
