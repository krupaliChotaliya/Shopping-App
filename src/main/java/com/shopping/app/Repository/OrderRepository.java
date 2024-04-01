package com.shopping.app.Repository;

import com.shopping.app.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "SELECT * FROM orders WHERE user_id = :userId", nativeQuery = true)
    List<Order> findOrderByUserId(int userId);

    @Query(value = "SELECT * FROM orders WHERE user_id = :userId And id = :orderId", nativeQuery = true)
    Order findOrderByUserIdAndOrderId(int userId,int orderId);

}
