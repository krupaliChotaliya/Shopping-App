package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Model.Coupon;
import com.shopping.app.Repository.CouponRepository;
import com.shopping.app.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public List<Coupon> getAllCoupon() {
        return couponRepository.findAll();
    }
}
