package inventory;

import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryDTO;
import com.algoriant.inventory.model.InventoryRequest;
import com.algoriant.inventory.repository.InventorytRepository;
import com.algoriant.inventory.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest (classes = com.algoriant.inventory.InventoryApplication.class)
public class InventoryServiceTest {

    @Mock
    private InventorytRepository inventorytRepository;
    @InjectMocks
    InventoryService inventoryService;

     @Test
    public void saveInventory(){
         try{
             Inventory inventory = new Inventory();
             inventory.setInventoryId(1);
             inventory.setItemId("Ma");
             inventory.setProductId(1);
             inventory.setLocation("StoreRoom1");
             inventory.setQuantity(40);
             inventory.setStatus("IN_STOCK");
             Inventory inventory1 = inventorytRepository.save(inventory);
             when(inventorytRepository.save(inventory1)).thenReturn(inventory1);
             assertEquals(inventory1,inventoryService.createInventory(InventoryRequest.toDto(inventory)));
         }catch (Throwable th){
             throw new RuntimeException("Error occurring while testing saveInventory method",th);
         }
     }
        @Test
        public void modifyInventory(){
            try{
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("MA");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(1);
                inventory.setStatus("IN_STOCK");
                when(inventorytRepository.findById(inventory.getInventoryId())).thenReturn(Optional.of(inventory));
                when(inventorytRepository.save(any())).thenReturn(inventory);
                Inventory inventory1 = inventoryService.modifyInventory(inventory.getInventoryId(),InventoryRequest.toDto(inventory));
                assertEquals(inventory.getItemId(),inventory1.getItemId());
            }catch (Throwable th){
                throw new RuntimeException("Error occurring while testing modifySupplier method",th);
            }
        }
        @Test
        public void removeInventory(){
            try{
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                inventorytRepository.save(inventory);
                inventoryService.removeInventory(inventory.getInventoryId());
                verify(inventorytRepository,times(1)).deleteById(inventory.getInventoryId());
            }catch (Throwable throwable){
                throw  new RuntimeException("Error while testing the removal of inventory",throwable);
            }
        }
        @Test
        public void getInventoryById(){
            try{
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                inventorytRepository.save(inventory);
                when(inventorytRepository.findById(inventory.getInventoryId())).thenReturn(Optional.of(inventory));
                InventoryDTO inventoryDTO =inventoryService.getInventory(inventory.getInventoryId());
                assertEquals(inventory.getItemId(),inventoryDTO.getItemId());
            }catch (Throwable throwable){
                throw  new RuntimeException("Error while testing the getInventoryById of inventory",throwable);
            }
        }
        @Test
        public void getAllInventory(){
            try{
                Inventory inventory = new Inventory();
                inventory.setInventoryId(1);
                inventory.setItemId("Ma");
                inventory.setProductId(1);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                Inventory inventory1 = new Inventory();
                inventory.setInventoryId(2);
                inventory.setItemId("Me");
                inventory.setProductId(2);
                inventory.setLocation("StoreRoom1");
                inventory.setQuantity(40);
                inventory.setStatus("IN_STOCK");
                List<Inventory> list = new ArrayList<>();
                list.add(inventory);
                list.add(inventory1);
                when(inventorytRepository.findAll()).thenReturn(list);
                assertEquals(list,inventorytRepository.findAll());
            }catch(Throwable throwable){
                throw new RuntimeException("Error while getting inventory",throwable);
            }
        }
}



