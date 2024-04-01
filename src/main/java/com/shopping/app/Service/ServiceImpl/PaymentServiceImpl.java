package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Model.Order;
import com.shopping.app.Model.Payment;
import com.shopping.app.Model.User;
import com.shopping.app.Repository.OrderRepository;
import com.shopping.app.Repository.PaymentRepository;
import com.shopping.app.Repository.UserRepository;
import com.shopping.app.Service.PaymentService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    private static int counter = 1;

    @Override
    public Payment makepayment(int userId, int orderID, int amount) {

        Payment payment = new Payment();
        try {
            Order optionalUser = orderRepository.findOrderByUserIdAndOrderId(userId,orderID);
            if (optionalUser == null) {
                throw new IllegalArgumentException("User not found");
            }

            Optional<Order> optionalOrder = orderRepository.findById(orderID);
            if (optionalOrder.isEmpty()) {
                throw new IllegalArgumentException("Payment Failed due to invalid order id");
            }

            User user = optionalUser.getUser();
            Order order1 = optionalOrder.get();

            if (Integer.parseInt(order1.getAmount()) != amount) {
                throw new IllegalArgumentException("Payment Failed as amount is invalid");

            }

            //To Renerate Random Transaction id
            Random random = new Random();
            int statusCode = random.nextInt(4) * 100 + 200;

            payment.setOrder(order1);
            payment.setUser(user);
            payment.setTransactionId(generateCode("tran010100"));

            if (statusCode == 400) {
                payment.setDescription("Payment Failed from bank");
                payment.setStatus("failed");
            } else if (statusCode == 504) {
                payment.setDescription("No response from payment server");
                payment.setStatus("failed");
            } else if (statusCode == 405) {
                payment.setStatus("failed");
                payment.setDescription("Order is already paid for");
            } else {
                payment.setStatus("success");
                payment.setDescription("payment is successful");
            }

            Payment savedPayment = paymentRepository.save(payment);
            return savedPayment;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateCode(String prefix) {
        String suffix = String.valueOf(counter++);
        return prefix + suffix;
    }

}
