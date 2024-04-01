package com.shopping.app.Controller;

import com.shopping.app.Model.Inventory;
import com.shopping.app.Repository.InventoryRepository;
import com.shopping.app.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getInventory(){
        List<Inventory> inventories=inventoryService.getInventory();
        System.out.println(inventories);
        Map<String, Object> jsonResponse = new HashMap<>();
        int ordered= (Integer.parseInt(inventories.get(0).getTotalQuantity())- Integer.parseInt(inventories.get(0).getAvailableQuantity()));
        jsonResponse.put("ordered",ordered);
        jsonResponse.put("price", inventories.get(0).getPrice());
        jsonResponse.put("available", inventories.get(0).getTotalQuantity());
        return ResponseEntity.ok().body(jsonResponse);
    }
}
