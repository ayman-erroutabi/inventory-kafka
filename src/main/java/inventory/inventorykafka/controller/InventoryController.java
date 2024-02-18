package inventory.inventorykafka.controller;

import inventory.inventorykafka.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public boolean isInventoryAvailableById(@RequestParam int id, @RequestParam int qty){
        return this.inventoryService.isInventoryAndAvailableQuantity(id,qty);
    }
}
