package com.shopping.app.Service;

import com.shopping.app.Model.Coupon;
import com.shopping.app.Model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {

    Payment makepayment(int userId, int orderID,int amount);
}
