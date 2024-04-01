package com.shopping.app.Controller;

import com.shopping.app.Model.Payment;
import com.shopping.app.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<Map<String, Object>> makePayment(@PathVariable int userId, @PathVariable int orderId, @RequestParam int amount) {

        Map<String, Object> jsonobject = new HashMap<>();
        try {
            Payment payment = paymentService.makepayment(userId, orderId, amount);
            jsonobject.put("userId", payment.getUser().getUserId());
            jsonobject.put("orderId", payment.getOrder().getId());
            jsonobject.put("transactionId", payment.getTransactionId());
            jsonobject.put("status", payment.getStatus());
            jsonobject.put("description", payment.getDescription());

            if (payment.getDescription() == "Payment Failed from bank") {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonobject);
            } else if (payment.getDescription() == "Order is already paid for") {
                return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(jsonobject);
            } else if (payment.getDescription() == "No response from payment server") {
                return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(jsonobject);
            }
            return ResponseEntity.status(HttpStatus.OK).body(jsonobject);
        } catch (Exception e) {
            jsonobject.put("description", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonobject);
        }

    }
}
