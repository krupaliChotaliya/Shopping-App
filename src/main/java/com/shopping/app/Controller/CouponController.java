package com.shopping.app.Controller;

import com.shopping.app.Service.CouponService;
import com.shopping.app.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;
}
