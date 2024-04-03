package com.shopping.app.Controller;

import com.shopping.app.Model.Order;
import com.shopping.app.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}/order")
    public ResponseEntity<Order> saveOrder(@PathVariable int userId, @RequestParam int qty,@RequestParam String coupon){
//        Map<String,Object> jsonResponse=new HashMap<>();
        Order order=orderService.saveOrder(userId,qty,coupon);
        try{

//            jsonResponse.put("orderId",order.getId());
//            jsonResponse.put("userId",order.getUser().getUserId());
//            jsonResponse.put("quantity",order.getQuantity());
//            jsonResponse.put("amount",order.getAmount());
//            jsonResponse.put("coupon",order.getCoupon().getCouponCode());
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(order);
        }
    }

//    @PostMapping("/{userId}/order")
//    public ResponseEntity<Map<String,Object>> saveOrder(@PathVariable int userId, @RequestParam int qty,@RequestParam String coupon){
//        Map<String,Object> jsonResponse=new HashMap<>();
//        try{
//            Order order=orderService.saveOrder(userId,qty,coupon);
//            jsonResponse.put("orderId",order.getId());
//            jsonResponse.put("userId",order.getUser().getUserId());
//            jsonResponse.put("quantity",order.getQuantity());
//            jsonResponse.put("amount",order.getAmount());
//            jsonResponse.put("coupon",order.getCoupon().getCouponCode());
//            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("description", e.getMessage()));
//        }
//    }

    @GetMapping("/{userId}/orders")
    public  ResponseEntity<List<Map<String, Object>>> getAllOrdersByUserId(@PathVariable int userId){

        try{
            List<Order> orders = orderService.getAllOrdersByUserId(userId);
            List<Map<String, Object>> jsonResponseList = new ArrayList<>();
            for (Order order : orders) {
                Map<String, Object> orderJson = new HashMap<>();
                orderJson.put("orderId", order.getId());
                orderJson.put("date", order.getDate());
                orderJson.put("amount", order.getAmount());
                orderJson.put("coupon", order.getCoupon().getCouponCode());
                jsonResponseList.add(orderJson);
            }
            return new ResponseEntity<>(jsonResponseList, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body((List<Map<String, Object>>) Collections.singletonMap("description", e.getMessage()));
        }

    }

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<Map<String, Object>> getALLOrderByOrderIDAndUserID(@PathVariable int userId,@PathVariable int orderId){
       try{
           Order order=orderService.getALLOrderByOrderIDAndUserID(userId,orderId);
           Map<String,Object> jsonResponse=new HashMap<>();
           jsonResponse.put("orderId",order.getId());
           jsonResponse.put("date",order.getDate());
           jsonResponse.put("amount",order.getAmount());
           jsonResponse.put("coupon",order.getCoupon().getCouponCode());
           jsonResponse.put("transactionId","2145678998");
           jsonResponse.put("status","success");
           return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("description", e.getMessage()));
       }

    }
}
