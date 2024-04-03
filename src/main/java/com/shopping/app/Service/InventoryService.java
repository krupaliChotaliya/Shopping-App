package com.shopping.app.Service;

import com.shopping.app.Model.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    List<Inventory> getInventory();

    int updateQuantity(String qty,String productName);

}
