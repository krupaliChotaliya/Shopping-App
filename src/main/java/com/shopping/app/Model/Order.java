package com.shopping.app.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private String amount;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "couponCode")
    private Coupon coupon;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate date = LocalDate.now();
}
