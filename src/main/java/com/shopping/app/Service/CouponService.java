package com.shopping.app.Service;

import com.shopping.app.Model.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponService {

    List<Coupon> getAllCoupon();
}
