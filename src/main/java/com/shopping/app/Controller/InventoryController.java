package com.shopping.app.Controller;

import com.shopping.app.Model.Inventory;
import com.shopping.app.Repository.InventoryRepository;
import com.shopping.app.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory")
    public ResponseEntity<List<Inventory>> getInventory(){
        List<Inventory> inventories=inventoryService.getInventory();
        System.out.println(inventories);

//        Map<String, Object> jsonResponse = new HashMap<>();
//        int ordered= (Integer.parseInt(inventories.get(0).getTotalQuantity())- Integer.parseInt(inventories.get(0).getAvailableQuantity()));
//        jsonResponse.put("ordered",ordered);
//        jsonResponse.put("price", inventories.get(0).getPrice());
//        jsonResponse.put("available", inventories.get(0).getTotalQuantity());
        return ResponseEntity.ok().body(inventories);
    }

//    @GetMapping("/inventory")
//    public ResponseEntity<Map<String, Object>> getInventory(){
//        List<Inventory> inventories=inventoryService.getInventory();
//        System.out.println(inventories);
//        Map<String, Object> jsonResponse = new HashMap<>();
//        int ordered= (Integer.parseInt(inventories.get(0).getTotalQuantity())- Integer.parseInt(inventories.get(0).getAvailableQuantity()));
//        jsonResponse.put("ordered",ordered);
//        jsonResponse.put("price", inventories.get(0).getPrice());
//        jsonResponse.put("available", inventories.get(0).getTotalQuantity());
//        return ResponseEntity.ok().body(jsonResponse);
//    }

    @PutMapping("/inventory")
    public ResponseEntity<String> updateAvailableQuantity(@RequestParam String qty, @RequestParam String productName) {
        int rowsAffected = inventoryService.updateQuantity(qty, productName);
        if (rowsAffected > 0) {
            return ResponseEntity.ok("Quantity updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found or quantity not updated");
        }
    }
}
