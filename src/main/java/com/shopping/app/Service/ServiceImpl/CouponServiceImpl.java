package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Repository.CouponRepository;
import com.shopping.app.Repository.ProductRepository;
import com.shopping.app.Service.CouponService;
import com.shopping.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;
}
