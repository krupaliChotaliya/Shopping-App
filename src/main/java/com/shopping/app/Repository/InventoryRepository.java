package com.shopping.app.Repository;

import com.shopping.app.Model.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update inventory set available_quantity = :qty where product_name = :productName", nativeQuery = true)
    int updateAvailableQuantity(@Param("qty") String qty, @Param("productName") String productName);

}

