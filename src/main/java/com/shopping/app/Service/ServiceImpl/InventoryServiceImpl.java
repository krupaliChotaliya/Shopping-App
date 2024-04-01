package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Model.Inventory;
import com.shopping.app.Repository.InventoryRepository;
import com.shopping.app.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }
}
