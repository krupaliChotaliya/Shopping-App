package com.shopping.app.Controller;

import com.shopping.app.Model.Coupon;
import com.shopping.app.Service.CouponService;
import com.shopping.app.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/fetchCoupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public ResponseEntity<List<Coupon>> getCoupon(){
        List<Coupon> coupons=couponService.getAllCoupon();
//        Map<String, Object> jsonResponse= new HashMap<>();
//        for(Coupon coupon : coupons){
//            jsonResponse.put(coupon.getCouponCode(),coupon.getDiscountPercentage());
//        }
          return ResponseEntity.ok().body(coupons);
    }

//    @GetMapping
//    public ResponseEntity<Map<String, Object>> getCoupon(){
//        List<Coupon> coupons=couponService.getAllCoupon();
//        Map<String, Object> jsonResponse= new HashMap<>();
//        for(Coupon coupon : coupons){
//            jsonResponse.put(coupon.getCouponCode(),coupon.getDiscountPercentage());
//        }
//        return ResponseEntity.ok().body(jsonResponse);
//    }

}
