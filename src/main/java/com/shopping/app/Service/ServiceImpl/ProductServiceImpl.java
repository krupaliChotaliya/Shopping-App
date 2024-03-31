package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Repository.ProductRepository;
import com.shopping.app.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
}
