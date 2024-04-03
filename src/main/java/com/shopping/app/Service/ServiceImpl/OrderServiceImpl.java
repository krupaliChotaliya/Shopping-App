package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Model.Coupon;
import com.shopping.app.Model.Inventory;
import com.shopping.app.Model.Order;
import com.shopping.app.Model.User;
import com.shopping.app.Repository.CouponRepository;
import com.shopping.app.Repository.InventoryRepository;
import com.shopping.app.Repository.OrderRepository;
import com.shopping.app.Repository.UserRepository;
import com.shopping.app.Service.InventoryService;
import com.shopping.app.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryService inventoryService;

    @Override
    public Order saveOrder(int userId,int qty,String coupon) {

        Optional<User> userOptional=userRepository.findById(userId);
        Coupon coupon1 = couponRepository.findCouponByCouponCode(coupon);

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User with id " + userId + " not found.");
        }

        if (coupon1 == null) {
            throw new IllegalArgumentException("Invalid coupon");
        }

        List<Inventory>inventoriesService=inventoryService.getInventory();
        // Check if quantity is valid
        if (Integer.parseInt(inventoriesService.get(0).getTotalQuantity()) < qty) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        //amount calculation
        List<Inventory> inventories=inventoryRepository.findAll();
        String amount = inventories.get(0).getPrice();
        int totalAmount = Integer.parseInt(amount)*qty;
        int discountPercentage = coupon1.getDiscountPercentage();

        double discount = (double) discountPercentage / 100.0;
        int afterDiscountAmount = (int) (totalAmount - (totalAmount * discount));

        User user = userOptional.get();
        Order order=new Order();
        order.setQuantity(qty);
        order.setUser(user);
        order.setCoupon(coupon1);
        order.setAmount(String.valueOf(afterDiscountAmount));
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrdersByUserId(int userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    @Override
    public Order getALLOrderByOrderIDAndUserID(int userId,int orderId) {
        return orderRepository.findOrderByUserIdAndOrderId(userId,orderId);
    }
}
