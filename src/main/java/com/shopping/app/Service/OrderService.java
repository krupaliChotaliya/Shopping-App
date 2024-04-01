package com.shopping.app.Service;

import com.shopping.app.Model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
     Order saveOrder(int userId,int qty,String coupon);

     List<Order> getAllOrdersByUserId(int userId);

     Order getALLOrderByOrderIDAndUserID(int userId,int orderId);
}
