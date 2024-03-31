package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Repository.OrderRepository;
import com.shopping.app.Repository.ProductRepository;
import com.shopping.app.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
}
